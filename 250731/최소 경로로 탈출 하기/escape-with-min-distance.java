import java.util.*;
public class Main {
    static int n,m;
    static int[][] grid;
    static int[][] step;
    static boolean[][] visited;

    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        step = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();
        // Please write your code here.

        bfs();

        if (step[n-1][m-1] == 0) System.out.print(-1);
        else System.out.print(step[n-1][m-1]);
    }

    public static boolean inbound(int x , int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    public static boolean canGo(int x, int y) {
        return inbound(x,y) && grid[x][y] == 1;
    }

    public static void push(int x, int y, int nextStep) {
        step[x][y] = nextStep;
    }

    public static void bfs() {

        Queue<int[]> q = new LinkedList();
        q.add(new int[]{0,0});
        visited[0][0] = true;
        step[0][0] = 0;

        while (!q.isEmpty()) {
            int[] poller = q.poll();
            int curX = poller[0];
            int curY = poller[1];

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (canGo(nx,ny) && !visited[nx][ny]) {
                    push(nx,ny,step[curX][curY]+1);
                    q.add(new int[]{nx,ny});
                    visited[nx][ny]= true;
                }
            }
        }
    }
}

// N M 
// 