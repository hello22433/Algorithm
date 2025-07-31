import java.util.*;
public class Main {
    static int n,r1,c1,r2,c2;
    static int[][] grid;
    static int[][] step;
    static boolean[][] visited;

    // 행열 -1,-2 / -2,-1 / -2,1 / -1,2 / 1,2 / 2,1 / 2,-1 / 1,-2
    static int[] dx = {-1,-2,-2,-1,1,2,2,1};
    static int[] dy = {-2,-1,1,2,2,1,-1,-2};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        r1 = sc.nextInt()-1;
        c1 = sc.nextInt()-1;
        r2 = sc.nextInt()-1;
        c2 = sc.nextInt()-1;

        grid = new int[n][n];
        step = new int[n][n];
        step[r2][c2] = -1;
        visited = new boolean[n][n];
        
        bfs();

        System.out.print(step[r2][c2]);
    }

    public static void push(int x, int y, int nextStep) {
        step[x][y] = nextStep;
    }

    public static boolean inbound(int x, int y) {
        return x >= 0 && x < n && y >=0 && y < n;
    }

    public static boolean canGo(int x, int y) {
        return inbound(x,y);
    }

    public static void bfs() {

        Queue<int[]> q = new LinkedList();
        q.add(new int[]{r1,c1});
        step[r1][c1] = 0;
        visited[r1][c1] = true;

        while (!q.isEmpty()) {

            int[] poller = q.poll();
            int curX = poller[0];
            int curY = poller[1];

            for (int i = 0; i < 8; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (canGo(nx,ny) && !visited[nx][ny]) {
                    push(nx,ny,step[curX][curY] + 1);
                    visited[nx][ny] = true;
                    q.add(new int[]{nx,ny});
                }
            }


        }
    }
}

// n n 
// 