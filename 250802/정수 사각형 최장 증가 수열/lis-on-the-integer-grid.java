import java.util.*;

public class Main {

    static int n;
    static int[][] grid;
    static int[][] dp;
    static int maxStep = 0;
    static Queue<int[]> pq;

    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        
        // Please write your code here.

        pq = new PriorityQueue<>((a,b) -> {
            int ax = a[0];
            int ay = a[1];
            int bx = b[0];
            int by = b[1];
            return grid[ax][ay] - grid[bx][by];
        });
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                pq.add(new int[]{i,j});
            }
        }
        bfs();
        System.out.print(maxStep+1);
    }

    public static boolean inbound(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public static boolean canGo(int nx, int ny, int curX, int curY) {
        return inbound(nx,ny) && grid[nx][ny] > grid[curX][curY];
    }

    public static void bfs() {

        while (!pq.isEmpty()) {
            int[] poller = pq.poll();
            int curX = poller[0];
            int curY = poller[1];

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (canGo(nx,ny,curX,curY)) {
                    dp[nx][ny] = Math.max(dp[nx][ny], dp[curX][curY]+1);
                    maxStep = Math.max(maxStep, dp[nx][ny]);
                }
            }
        }
    }
}

// 250000 

// 하나 골라 ! 출발해 ! 
// 만약 도착하는 곳보다 지금 걸었던 수가 더 작으면 최소값 갱신하고 계속 걸어! 아니면 가지마.