import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] w = new int[n];
        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }

        // dp[i][j]: 처음 i개의 보석 중에서 무게 제한 j일 때 최대 가치
        int[][] dp = new int[n+1][m+1];

        for (int i = 1; i <= n; i++) {
            int weight = w[i-1];
            int value = v[i-1];

            for (int j = 0; j <= m; j++) {
                if (j >= weight) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - weight] + value);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        System.out.println(dp[n][m]);
    }
}
