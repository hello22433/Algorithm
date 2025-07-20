import java.util.Scanner;
public class Main {
    static int[][] grid;
    static int n;

    // 동 남 서 북 0 1 2 3 
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        // Please write your code here.
        int maxTime = 0;

        // 동의 1행에서 n행까지 실행 (열은 n으로 고정)
        for (int i = 0; i < n; i++) {
            int time = simulatePinball(i, n-1, 2);
            maxTime = Math.max(maxTime, time);
        }

        // 남
        for (int i = 0; i < n; i++) {
            int time = simulatePinball(n-1, i, 3);
            maxTime = Math.max(maxTime, time);
        }

        // 서
        for (int i = 0; i < n; i++) {
            int time = simulatePinball(i, 0, 0);
            maxTime = Math.max(maxTime, time);
        }

        // 북
        for (int i = 0; i < n; i++) {
            int time = simulatePinball(0, i, 1);
            maxTime = Math.max(maxTime, time);
        }

        System.out.print(maxTime);
    }

    public static int simulatePinball(int x, int y, int dir) {
        // 처음 들어갈때도 한 번 움직이는 것으로 카운트해야 한다.
        int spentTime = 1;

        // 주어진 방향은 전의 방향이다.
        // 현재 칸과 상호작용 후, 방향을 바꾼다음 지금 명령에 따라 움직여야 한다.

        // 방향을 구한다
        // 움직인다.

        while (true) {
            if (grid[x][y] == 1) { // /
                if (dir == 0) dir = 3;
                else if (dir == 1) dir = 2;
                else if (dir == 2) dir = 1;
                else if (dir == 3) dir = 0;
            } else if (grid[x][y] == 2) { // \
                if (dir == 0) dir = 1;
                else if (dir == 1) dir = 0;
                else if (dir == 2) dir = 3;
                else if (dir == 3) dir = 2;
            }
            
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            spentTime++; // 탈출 시에도 한 번 이동하는 것으로 처리하기 때문에 인바운드 체크 전에 카운트해야 한다. 
            if (!inBound(nx, ny)) break;

            x = nx;
            y = ny;
        }
        return spentTime;
    }

    public static boolean inBound(int x, int y) {
        if (x >= 0 && x < n && y >= 0 && y < n) return true;
        return false;
    }
}

// 모든 시작점에서 날려보면 된다. 
// 동 남 서 북
// 진행 방향은 시작하는 방향의 반대방향 (북에서 시작하면 진행 방향은 남)
// 