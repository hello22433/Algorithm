import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.

        long[] dp = new long[n+1];

        dp[0] = 1;
        dp[1] = 2;
        if (n>=2) dp[2] = 7;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i-2]*3 + dp[i-1]*2) % 1000000007;
                for (int j = i - 3; j >= 0; j--) {
                    dp[i] = (dp[i] + 2 * dp[j]) % 1000000007;
                }
        }

        System.out.print(dp[n]);
    }
}

// 3 끝은 7가지가 있다. 
// ㄹ