import java.util.*;

public class Main {

    static int n,k,r1,c1,r2,c2;

    static int[][] grid;
    static boolean[][] visited;
    static int[][] step;

    static List<int[]> wallsXY = new ArrayList();

    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    static int minTimes = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();

                if (grid[i][j] == 1) wallsXY.add(new int[]{i,j});
            }
        }
        r1 = sc.nextInt()-1;
        c1 = sc.nextInt()-1;
        r2 = sc.nextInt()-1;
        c2 = sc.nextInt()-1;
        
        // Please write your code here.

        destoryWallsFindMinTimes(0,0);

        if (minTimes == Integer.MAX_VALUE) System.out.print(-1);
        else System.out.print(minTimes);
    }

    public static void pushStep(int x, int y, int steps) {
        step[x][y] = steps;
    }

    public static boolean inbound(int x , int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public static boolean canGo(int x, int y) {
        return inbound(x,y) && grid[x][y] == 0;
    }

    public static void bfs() {

        Queue<int[]> q = new LinkedList();
        q.add(new int[]{r1,c1});
        step[r1][c1] = 0;
        visited[r1][c1] = true;

        outer : while (!q.isEmpty()) {
            int[] poller = q.poll();
            int curX = poller[0];
            int curY = poller[1];

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (canGo(nx,ny) && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    pushStep(nx,ny,step[curX][curY]+1);
                    q.add(new int[]{nx,ny});
                }

                if (nx == r2 && ny == c2) break outer;
            }
        }

        if (visited[r2][c2])
            minTimes = Math.min(minTimes, step[r2][c2]);
    }

    public static void destoryWallsFindMinTimes(int startIdx, int depth) {
        if (depth == k) {
            visited = new boolean[n][n];
            step = new int[n][n];

            bfs();
            return;
        }

        for (int i = 0; i < wallsXY.size(); i++) {
            int x = wallsXY.get(i)[0];
            int y = wallsXY.get(i)[1];
            grid[x][y] = 0;
            destoryWallsFindMinTimes(i+1, depth+1);
            grid[x][y] = 1;
        }
    }
}

// K개의 벽 없애기
// 0,1 n n
// 