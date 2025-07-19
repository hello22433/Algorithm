import java.util.Scanner;

public class Main {

    // 동 남 서 북 0 1 2 3
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static int n,m,r,c;
    static char[] directions;

    static int[][] board;

    // 위 아래 앞 뒤 왼 오
    static int[] dice = {1, 6, 2, 5, 4, 3};
    static int currentRollNum = 6;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        r = sc.nextInt()-1;
        c = sc.nextInt()-1;
        directions = new char[m];
        for (int i = 0; i < m; i++) {
            directions[i] = sc.next().charAt(0);
        }
        board = new int[n][n];

        simulateRollDice();
        int result = sumBoardNumber();
        System.out.print(result);
    }

    public static void simulateRollDice() {
        int x = r;
        int y = c;
        // 현재 칸에 바닥면의 주사위를 찍어둠
        board[x][y] = dice[1];

        // 방향을 모두 돌림
        for (int t = 0; t < m; t++) {

            char dirInfo = directions[t];
            int dir = -1;
            if (dirInfo == 'R') dir = 0;
            if (dirInfo == 'D') dir = 1;
            if (dirInfo == 'L') dir = 2;
            if (dirInfo == 'U') dir = 3;

            // 다음 칸으로 이동
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            // 이동한 칸이 인바운드라면 주사위를 굴린다.
            if (inBound(nx, ny)) {
                if (dir == 0) {
                    rollRight();
                } else if (dir == 1) {
                    rollDown();
                } else if (dir == 2) {
                    rollLeft();
                } else {
                    rollUp();
                }

                x = nx;
                y = ny;
                // 이동 후, 찍어야 하는 수를 주사위의 바닥으로 설정하고 찍기
                currentRollNum = dice[1];
                board[x][y] = currentRollNum;
            }
        }
    }

    public static void rollRight() {
        int top = dice[0], bottom = dice[1], left = dice[4], right = dice[5];
        dice[0] = left;
        dice[1] = right;
        dice[4] = bottom;
        dice[5] = top;
    }

    public static void rollLeft() {
        int top = dice[0], bottom = dice[1], left = dice[4], right = dice[5];
        dice[0] = right;
        dice[1] = left;
        dice[4] = top;
        dice[5] = bottom;
    }

    public static void rollDown() {
        int top = dice[0], bottom = dice[1], front = dice[2], back = dice[3];
        dice[0] = back;
        dice[1] = front;
        dice[2] = top;
        dice[3] = bottom;
    }

    public static void rollUp() {
        int top = dice[0], bottom = dice[1], front = dice[2], back = dice[3];
        dice[0] = front;
        dice[1] = back;
        dice[2] = bottom;
        dice[3] = top;
    }

    public static int sumBoardNumber() {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // System.out.print(board[i][j] + " ");
                sum += board[i][j];
            }
            // System.out.println();
        }
        return sum;
    }

    public static boolean inBound(int x, int y) {
        if (x >= 0 && x < n && y >= 0 && y < n) return true;
        return false;
    }
}