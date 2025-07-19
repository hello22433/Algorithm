import java.util.*;

public class Main {

    static int n, m, r, c;
    static int[][] board;

    // 동 남 서 북 0 1 2 3
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        r = sc.nextInt()-1;
        c = sc.nextInt()-1;

        board = new int[n][n];

        simulateBooms();
        int result = cntBoom();
        System.out.print(result);
    }

    public static void simulateBooms() {
        int x = r;
        int y = c;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});
        board[x][y] = 1;

        for (int t = 1; t <= m; t++) {

            int qSize = q.size();

            for (int i = 0; i < qSize; i++) {
                // 폭탄은 남아서 계속 터지기 때문
                int[] poller = q.poll();
                int curX = poller[0];
                int curY = poller[1];
                q.offer(new int[]{curX,curY});
            
                for (int j = 0; j < 4; j++) {
                    int nx = curX + dx[j] * (int)Math.pow(2, t-1);
                    int ny = curY + dy[j] * (int)Math.pow(2, t-1);
                    
                    if (inBound(nx, ny)) {
                        board[nx][ny] = 1;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }

    public static boolean inBound(int x, int y) {
        if (x >= 0 && x < n && y >= 0 && y < n) return true;
        return false;
    }

    public static int cntBoom() {
        int sum = 0;
        for (int i = 0; i < n; i++) 
            for (int j = 0; j < n; j++) 
                sum += board[i][j];

        return sum;
    }
}

// 