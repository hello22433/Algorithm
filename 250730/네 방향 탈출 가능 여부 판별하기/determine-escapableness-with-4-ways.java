import java.util.*;
public class Main {

    static int n,m;
    static int[][] grid;
    static boolean[][] visited;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();
        // Please write your code here.

        int canEscape = bfs();

        System.out.print(canEscape);
    }

    public static boolean inbound(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    public static boolean canGo(int x, int y) {
        if (inbound(x ,y) && grid[x][y] == 1) return true;
        return false;
    }

    public static int bfs() {

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] poller = q.poll();
            int x = poller[0];
            int y = poller[1];

            // System.out.println(x + " " + y);
            if (x == n-1 && y == m-1) return 1;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (canGo(nx,ny) && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx,ny});
                }
            }
        }

        return 0;
    }
}

// n m
// 