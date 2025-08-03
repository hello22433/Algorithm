import java.util.Scanner;

public class Main {
    static int n;
    static int[][] board;
    static final int INF = Integer.MAX_VALUE;

    // low 기준으로 경로가 가능한지 체크하며 dp 배열 채우기
    static int check(int low) {
        int[][] dp = new int[n][n];

        // 초기화: INF로 채우기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = INF;
            }
        }

        // 시작점도 low 조건 검사
        if (board[0][0] < low) return INF;
        dp[0][0] = board[0][0];

        // 첫 행
        for (int j = 1; j < n; j++) {
            if (board[0][j] < low || dp[0][j - 1] == INF) {
                dp[0][j] = INF;
            } else {
                dp[0][j] = Math.max(dp[0][j - 1], board[0][j]);
            }
        }

        // 첫 열
        for (int i = 1; i < n; i++) {
            if (board[i][0] < low || dp[i - 1][0] == INF) {
                dp[i][0] = INF;
            } else {
                dp[i][0] = Math.max(dp[i - 1][0], board[i][0]);
            }
        }

        // 나머지 칸들
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (board[i][j] < low) {
                    dp[i][j] = INF;
                } else {
                    int fromUp = dp[i - 1][j];
                    int fromLeft = dp[i][j - 1];

                    if (fromUp == INF && fromLeft == INF) {
                        dp[i][j] = INF; // 둘 다 경로 불가
                    } else {
                        int minPrev = Math.min(fromUp, fromLeft);
                        dp[i][j] = Math.max(minPrev, board[i][j]);
                    }
                }
            }
        }

        return dp[n - 1][n - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        int res = INF;
        // low 값을 1부터 100까지 시도
        for (int low = 1; low <= 100; low++) {
            int ans = check(low);
            if (ans != INF) {
                res = Math.min(res, Math.abs(ans - low));
            }
        }

        System.out.println(res);
        sc.close();
    }
}
