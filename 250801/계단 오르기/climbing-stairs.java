import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.



        int[] dp = new int[n+4];
        dp[0] = 1;

        for (int i = 0; i <=n; i++) {
            dp[i+2] = (dp[i+2] + dp[i]) % 10007;
            dp[i+3] = (dp[i+3] + dp[i]) % 10007;
        }

        System.out.print(dp[n]);
    }
}