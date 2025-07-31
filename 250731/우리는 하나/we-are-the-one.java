import java.util.*;
public class Main {

    static int n,k,u,d;
    static int[][] grid;
    static boolean[][] visited;
    static int[][] kCitiesPoints;

    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    static int maxMovesToCitys = 1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        u = sc.nextInt();
        d = sc.nextInt();
        grid = new int[n][n];
        kCitiesPoints = new int[k][2];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        // Please write your code here.

        // 

        dfs(0, 0);

        System.out.print(maxMovesToCitys);
    }

    public static boolean inbound(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public static boolean canGo(int x, int y, int diff) {
        return inbound(x,y) && diff >= u && diff <= d;
    }

    public static int bfs(int x, int y) {

        Queue<int[]> q = new LinkedList();
        q.add(new int[]{x,y});
        int moves = 1;
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] poller = q.poll();
            int curX = poller[0];
            int curY = poller[1];

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (!inbound(nx,ny)) continue;

                int diff = Math.abs(grid[curX][curY] - grid[nx][ny]);

                if (canGo(nx,ny,diff) && !visited[nx][ny]) {
                    q.add(new int[]{nx,ny});
                    visited[nx][ny] = true;
                    moves++;
                }

            }   
        }
        return moves;
    }

    public static void dfs(int startJ, int depth) {

        if (depth == k) {
            int moves = 0;
            visited = new boolean[n][n];

            for (int i = 0; i < k; i++) {
                int x = kCitiesPoints[i][0];
                int y = kCitiesPoints[i][1];
                if (!visited[x][y]) 
                    moves += bfs(x,y);
            }

            maxMovesToCitys = Math.max(maxMovesToCitys, moves);
            return;
        } 

        for (int i = 0; i < n; i++) {
            for (int j = startJ; j < n; j++) {
                kCitiesPoints[depth] = new int[]{i,j};
                dfs(j + 1, depth + 1);

            }
        }

    }
}

// 각 칸마다 하나의 도시의 높이 -> K개의 도시를 적절히 고름 -> 이 도시로부터 갈 수 있는 서로 다른 ㅗㄷ시 수를 최대화
// 이동: 상하좌우 인접한 도시간의 이동만 가능 : 그 중에서도 높이의 차가 U이상 D이하인 경우만 가능 
// 
// 도시를 고름 -> 상하좌우로 이동 -> 높이 차이는 이동한 곳의 높이를 갱신해서 계속 이동

// k개의 도시를 고를 것이다.
// dfs로 k에 도달하면 멈춘다.
// k개의 도시를 어떻게 구할건데?
// new int[][]