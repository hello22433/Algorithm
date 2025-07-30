import java.util.Scanner;
public class Main {
    static int n, m, k;
    static int[][] grid;
    static boolean[][] visited;

    // 동 남 서 북
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();

        int maxCntSafeZone = 0;
        int maxCntSafeZoneAtK = 0;

        for (k = 100; k >= 1; k--) {
            int cntSafeZone = 0;
            visited = new boolean[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!visited[i][j] && grid[i][j] > k) {
                        cntSafeZone++;
                        visited[i][j] = true;
                        dfs(i,j);
                    }
                }
            }

            if (cntSafeZone >= maxCntSafeZone) {
                maxCntSafeZone = cntSafeZone;
                maxCntSafeZoneAtK = k;
            }
        }

        System.out.print(maxCntSafeZoneAtK + " " + maxCntSafeZone); 
    }

    public static boolean inbound(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    public static boolean canGo(int x, int y) {
        if (inbound(x,y) && grid[x][y] > k) return true;
        return false; 
    }

    public static void dfs(int x, int y) {

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (canGo(nx, ny) && !visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx, ny);
            }
        }

    }
}

// N M 
// 격자마다 한 집의 높이를 의미
// 높이가 K이하면 전부 물에 잠김
// K에 따라 안전 영역의 개수
// 잠기지 않은 집들
// 안전영역 = 잠기지 않은 집들끼리, 서로 인접해 있는 경우 동일안 안전영역 (상하좌우로만)

// K를 1부터 100(집높이의 최소값과 최대값)까지 탐색한다. 
// K가 0일떈 1 ... K가 높아질 때마다 안전구역이 생길 수 있다.
// 
// K * N * M