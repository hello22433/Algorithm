import java.util.Scanner;

public class Main {

    static int maxBlockCnt = 0;
    static int boomBlock = 0;
    static int n;
    static boolean[][] visited;
    static int[][] grid;

    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        // Please write your code here.
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (!visited[i][j]){
                    visited[i][j] = true;
                    int blockCnt = dfs(i,j, grid[i][j]);
                    if (blockCnt >= 4) {
                        boomBlock++;
                    }
                    maxBlockCnt = Math.max(maxBlockCnt, blockCnt);
                }
            }
        }

        System.out.print(boomBlock + " " + maxBlockCnt);
    }

    public static boolean inbound(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public static boolean canGo(int x, int y, int startVal) {
        if (inbound(x ,y) && grid[x][y] == startVal) return true;
        return false;
    }

    public static int dfs(int x, int y, int startVal) {
        int blockCnt = 1;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (canGo(nx, ny, startVal) && !visited[nx][ny] && grid[nx][ny] == startVal) {

                visited[nx][ny] = true;
                blockCnt += dfs(nx,ny,startVal);
            }
        }

        return blockCnt;
    }
}



// 1 ~ 100 n n
// 상하좌우 같은 숫자 -> 하나의 블럭 -> 4개 이상이면 터짐
// 터지는 블럭의 개수 , 가장 큰 블럭의 크기
// 방문하지 않은 곳에 방문한다. 개수를 리턴한다.
// 만약 개수가 4개 이상이면 터지는 블럭개수 +1
// 가장큰 블럭의 크기는 개수를 체크할 때 최대값 갱신한다.