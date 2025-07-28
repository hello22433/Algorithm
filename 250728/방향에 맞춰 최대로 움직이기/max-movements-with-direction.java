import java.util.*;
public class Main {

    // x 북 북동 동 동남 남 남서 서 서북 
    static int[] dx = {9, -1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {9, 0, 1, 1, 1, 0, -1, -1, -1};

    static int n,r,c;
    static int[][] num, moveDir;

    static int maxMoves = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        num = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                num[i][j] = sc.nextInt();
            }
        }
        moveDir = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                moveDir[i][j] = sc.nextInt();
            }
        }
        r = sc.nextInt()-1;
        c = sc.nextInt()-1;
        // Please write your code here.
        
        dfs(r, c, 0);
        System.out.print(maxMoves);
    }

    public static void dfs(int x, int y, int moves) {
        

        for (int i = 1; i <= n-1; i++) {
            int nx = x + i * dx[moveDir[x][y]];
            int ny = y + i * dy[moveDir[x][y]];

            if (inBound(nx,ny) && num[x][y] < num[nx][ny]) {
                dfs(nx, ny, moves+1);
            } else {
                maxMoves = Math.max(maxMoves, moves);
            }
        }
    }

    public static boolean inBound(int x ,int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}

// 1 ~ NxN 이하의 정수 와, 여덟 방향 중 한 방향으로 이루어진 N x N 크기의 격자
// 수 중복 x , 

// 더 큰 수로 이동, 방향 내에서는 무제한 이동(건너뛰기가능) , 
// 더 커야하고, inBound여야 한다. 
// dfs? bfs? 깊이 들어가는거다보니 dfs가 맞을 것이다.
// 이동할 곳이 없으면 Return ! (inbound가 없거나, 큰 값이 없거나)