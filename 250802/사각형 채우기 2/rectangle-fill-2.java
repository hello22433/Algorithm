import java.util.Scanner;
public class Main {

    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp = new int[n+1];

        dp[1] = 1;
        if (n>=2) dp[2] = 3;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]*2) % 10007;
        }

        System.out.print(dp[n]);
    }
}

// dp[1] = 1
// dp[2] = 3
// dp[3] = dp[2] + dp1 *2