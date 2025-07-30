import java.util.*;
public class Main {

    static int n, m;
    static int[][] grid;
    static boolean[][] visited;
    static List<int[]> twoPoints;
    static int lastIceSize = 0;

    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();
        // Please write your code here.

        int t = 0;
        for (t = 0; ; t++) {
            twoPoints = new ArrayList<>();
            visited = new boolean[n][m];
            int curIceSize = bfs(0,0);
            if (curIceSize != 0) lastIceSize = curIceSize;
            else break;

            // visited = new boolean[n][m];
            // for (int i = 0; i < twoPoints.size(); i++) {
            //     if (!visited[twoPoints.get(i)[0]][twoPoints.get(i)[1]])
            //         lastIceSize = bfs(twoPoints.get(i)[0], twoPoints.get(i)[1]);
            // }

        }

        System.out.print(t + " " + lastIceSize);
    }

    public static int bfs(int x, int y) {
        int iceSize = 0;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        // int bfsValue = grid[x][y];
        visited[x][y] = true;

        while (!q.isEmpty()) {

            int[] poller = q.poll();
            int curX = poller[0];
            int curY = poller[1];

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (canGo(nx,ny) && !visited[nx][ny]) {
                    visited[nx][ny] = true;

                    if (grid[nx][ny] == 0) { // 0이나 2인 경우
                        q.add(new int[]{nx,ny});
                    } else if (grid[nx][ny] == 1) {
                        // twoPoints.add(new int[]{nx,ny});
                        grid[nx][ny] = 0;
                        iceSize++;
                    } 
                    // else if (grid[nx][ny] == 2) {
                    //     grid[nx][ny] = 1;

                    // }

                }
            }
        }

        return iceSize;
    }

    public static boolean inbound(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    public static boolean canGo(int x, int y) {
        return inbound(x,y);
    }
}


// N M
// 격자의 가장 바깥부분은 항상 빙하 X
// 빙하를 제외한 나머지 위치 = 물
// 1 빙하 , 0 물
// 빙하 1초에 한 번씩 물에 닿아있는 부분들이 동시에 녹음
// 빙하로 둘려쌓여있는 물은 붙어있는 빙하를 녹이지 못함
// 닿아있음 : 상하좌우로 인접
// 
// 맨 바깥쪽 빙하와 연결되어 있어야 빙하에 둘러쌓여 있지 않은 것임
// 물에 닿아있는 부분들이 동시에 녹는다. : 물에 상하좌우로 인접한 부분들이 동시에 녹는다.
// 
// 0,0으로부터 시작해서 인접한 부분을 구한다.
// 만약 1인 경우 2로 바꾼다. 2의 좌표를 저장해놓는다. 
// bfs가 끝난 이후, 2의 좌표들을 시작 좌표로 해서 bfs하며 2인 경우 0으로 바꾼다.
// 즉, bfs는 1인 경우 2로 바꾸고, 2인 경우 0으로 바꿔야 한다. 
// 2로 바꾼게 그 bfs에서 바로 0으로 바뀌지 않음은, 이미 방문처리를 했기 때문이다.
// 
// 무한으로 돌리다가 만약, 