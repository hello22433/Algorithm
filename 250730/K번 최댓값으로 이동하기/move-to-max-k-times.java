import java.util.*;

public class Main {
    static int n, k, r, c;
    static int[][] grid;
    static boolean[][] visited;

    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        grid = new int[n][n];
        
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        r = sc.nextInt()-1;
        c = sc.nextInt()-1;
        // Please write your code here.

        simulateMoves();
        System.out.print(r+1 + " " + (c+1));
    }

    public static boolean inbound(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public static void simulateMoves() {

        for (int T = 0; T < k; T++) {
            
            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{r,c});
            visited = new boolean[n][n];
            visited[r][c] = true;
            int sideMaxValue = 0;

            boolean check = false;

            while (!q.isEmpty()) {
                int[] poller = q.poll();
                int x = poller[0];
                int y = poller[1];

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (inbound(nx,ny) && grid[r][c] > grid[nx][ny] && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        check = true;
                        sideMaxValue = Math.max(sideMaxValue, grid[nx][ny]);
                        q.add(new int[]{nx,ny});
                    }
                }

            }
                        // System.out.println(grid[r][c] + " " + sideMaxValue);
            

            if (check) {
                int[] xy = findXYofValue(sideMaxValue);
                r = xy[0];
                c = xy[1];
            } else {
                return;
            }
        }
    }


    public static int[] findXYofValue(int val) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == val && visited[i][j]) {
                    return new int[]{i,j};
                }
            }
        }

        return new int[]{-1,-1};
    }
}

// 1 ~ 100
// N x N
// 특정위치에서 시작 , 조건 만족하는 인접 상하좌우
// K번 반복 : 움직일곳 없으면 끝남
// 
// x보다 작은 곳으로 전부 이동 가능 : 이중 최대값으로 이동 : 최대값이 여러개면, 행 번호가 가장 작은 곳으로 이동 : 행도 같으면 열 번호가 작은 곳
// -> 북 서 동 남
// 

// 상하좌우에서 최대값 찾음
// 만약 최대값이 원래 값보다 작으면  (안 작으면 작업을 끝냄)
// n n 탐색해서 그 값을 찾음
// 그 값을 찾는 순간 x,y를 갱신해서(전역변수) 이동(0,0부터 탐색하므로 조건 만족) 
// 