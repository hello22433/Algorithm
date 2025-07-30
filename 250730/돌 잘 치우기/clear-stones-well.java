import java.util.*;
public class Main {
    static int n,k,m;
    static int[][] grid, startPoints; 
    static List<int[]> stonePoints;
    static int maxPossibleRooms = 0;

    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    static boolean[][] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][n];
        
        stonePoints = new ArrayList();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                if (grid[i][j] == 1)
                    stonePoints.add(new int[]{i,j});
            }
        }
        startPoints = new int[k][2];
        for (int i = 0; i < k; i++) {
            startPoints[i][0] = sc.nextInt()-1;
            startPoints[i][1] = sc.nextInt()-1;
        }
        // Please write your code here.

        dfs(0, 0);
        System.out.print(maxPossibleRooms);
    }

    public static boolean inbound(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public static boolean canGo(int x, int y) {
        return inbound(x, y) && grid[x][y] == 0;
    }

    public static int bfs(int x, int y) {

        int totalMoves = 1;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            
            int[] poller = q.poll();
            int curX = poller[0];
            int curY = poller[1];

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (canGo(nx,ny) && !visited[nx][ny]) {
                    q.add(new int[]{nx,ny});
                    visited[nx][ny] = true;
                    totalMoves++;
                }
            }
        }

        return totalMoves;
    }

    public static void dfs(int startIdx, int depth) {
        if (depth == m) {
            int totalMoves = 0;
            visited = new boolean[n][n];
            for (int i = 0; i < k; i++) {
                if (!visited[startPoints[i][0]][startPoints[i][1]])
                    totalMoves += bfs(startPoints[i][0], startPoints[i][1]);
            }
            maxPossibleRooms = Math.max(maxPossibleRooms, totalMoves);
            return;
        }

        for (int i = startIdx; i < stonePoints.size(); i++) {
            int[] stoneXY = stonePoints.get(i);
            int stoneX = stoneXY[0];
            int stoneY = stoneXY[1];
            grid[stoneX][stoneY] = 0; 
            dfs(i + 1, depth +1);
            grid[stoneX][stoneY] = 1; 
        }
    }
}



// 0, 1 n n
// 1돌 주어진돌중 M개를 적절히 치워라 -> K개의 시작점으로부터 상하좌우 인접한 곳으로만 이동하여 도달 가능한 칸의 수를 최대로 하라
// 0으로만 이동 가능


// m개를 조합으로 모두 제거해본다.
// 제거 한 후에, bfs로 모든 시작점에서 돌아 가능한 칸의 개수를 구한다.
// 최대값을 갱신한다.
// m개의 조합을 모두 시도할 때까지 반복...