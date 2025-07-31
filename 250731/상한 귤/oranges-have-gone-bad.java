import java.util.*;

public class Main {
    static int n,k;
    static int[][] grid;

    static int[][] minStepGrid;
    static boolean[][] visited;
    static int[][] spoiledTangerineXY;

    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        grid = new int[n][n];
        spoiledTangerineXY = new int[k][2];
        minStepGrid = new int[n][n];

        int tangerineIdx = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {

                grid[i][j] = sc.nextInt();
                if (grid[i][j] == 2) {
                    spoiledTangerineXY[tangerineIdx][0] = i;
                    spoiledTangerineXY[tangerineIdx++][1] = j;
                } else if (grid[i][j] == 0) {
                    minStepGrid[i][j] = -1;
                }
            }
        // Please write your code here.

        for (int i = 0; i < k; i++) {
            int x = spoiledTangerineXY[i][0];
            int y = spoiledTangerineXY[i][1];

            visited = new boolean[n][n];
            bfs(x,y);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && minStepGrid[i][j] == 0) System.out.print(-2 + " ");
                else System.out.print(minStepGrid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean inbound(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public static boolean canGo(int x, int y) {
        return inbound(x,y) && grid[x][y] == 1; 
    }

    public static void pushStep(int x, int y, int steps) {
        if (minStepGrid[x][y] == 0) {
            minStepGrid[x][y] = steps;
        } else {
            minStepGrid[x][y] = Math.min(minStepGrid[x][y], steps);
        }
    }

    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList();
        q.add(new int[]{x,y});
        visited[x][y] = true;
        minStepGrid[x][y] = 0;

        while (!q.isEmpty()) {
            int[] poller = q.poll();
            int curX = poller[0];
            int curY = poller[1];

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (canGo(nx,ny) && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    pushStep(nx,ny,minStepGrid[curX][curY] + 1);
                    q.add(new int[]{nx,ny});
                }
            }
        }
    }


}

// 0 1 2 
// n n
// 0초에 K개의 상한 귤로부터 시작 -> 1초에 한 번씩 모든 상한 귤로부터 인접한 곳에 있는 귤이 동시에 전부 상함
// 각 귤마다 최초로 상하게 되는 시간
// 0 : 아무것도 없음
// 1 : 귤 놓여있음
// 2 : 상한 귤이 놓여있음

// 처음부터 빈 곳 -1 , 귤이 들어있었다면 상하는데까지 걸린 시간
// 상하지 않은 귤이면 -2
// 0이 아닐떈 최소값 갱신, 0이면 그냥 넣는다.