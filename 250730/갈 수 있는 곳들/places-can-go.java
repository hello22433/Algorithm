import java.util.*;
public class Main {
    static int n,k;
    static int[][] grid;
    static boolean[][] visited;
    static int moves = 0;

    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        grid = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        int[][] starts = new int[k][2];
        for (int i = 0; i < k; i++) {
            starts[i][0] = sc.nextInt()-1;
            starts[i][1] = sc.nextInt()-1;
        }
        // Please write your code here.

        for (int i = 0; i < k; i++) {
            if (!visited[starts[i][0]][starts[i][1]]) {
                moves++;
                visited[starts[i][0]][starts[i][1]] = true;
                bfs(starts[i][0], starts[i][1]);
            }
        }
        System.out.print(moves);
    }

    public static boolean inbound(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public static boolean canGo(int x, int y) {
        if (inbound(x, y) && grid[x][y] == 0) return true;
        return false;
    }

    public static void bfs(int x , int y) {


        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});

        while (!q.isEmpty()) {
            int[] poller = q.poll();
            int curX = poller[0];
            int curY = poller[1];

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (canGo(nx,ny) && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    moves++;
                    q.add(new int[]{nx,ny});
                }
            }
        }
    }
}


// 0, 1
// N N 
// K개의 시작점
// 

// 출발할때 : 카운트1추가, 방문추가