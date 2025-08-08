import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] coin = new int[n];
        for (int i = 0; i < n; i++) {
            coin[i] = sc.nextInt();
        }
        // Please write your code here.

        int INF_MIN = Integer.MIN_VALUE;

        int[] dp = new int[m+1];
        Arrays.fill(dp, INF_MIN);
        dp[0] = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 0; j < n; j++) {
                if (i-coin[j] >= 0 && dp[i-coin[j]] != INF_MIN)
                    dp[i] = Math.max(dp[i], dp[i - coin[j]] + 1);
            }
        }

        if (dp[m] != INF_MIN) System.out.print(dp[m]);
        else System.out.print(-1);
        
    }
}

// dp[i] = 금액 i을 만들기 위한 최대 동전 수