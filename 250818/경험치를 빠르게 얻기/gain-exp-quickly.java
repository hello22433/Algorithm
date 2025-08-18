import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] exp = new int[n];
        int[] time = new int[n];
        int sumExp = 0;

        for (int i = 0; i < n; i++) {
            exp[i] = sc.nextInt();
            time[i] = sc.nextInt();
            sumExp += exp[i];
        }

        int INF = Integer.MAX_VALUE / 2; // 오버플로 방지
        int[] dp = new int[sumExp + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = sumExp; j >= exp[i]; j--) {
                dp[j] = Math.min(dp[j], dp[j - exp[i]] + time[i]);
            }
        }

        int ans = INF;
        for (int i = m; i <= sumExp; i++) {
            ans = Math.min(ans, dp[i]);
        }

        System.out.println(ans);
    }
}
