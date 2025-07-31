import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.

        int[] dp = new int[n+1];

        dp[1] = 2;
        if (n>=2) dp[2] = 7;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i-2]*4 + dp[i-1]*2) % 1000000007;
        }

        System.out.print(dp[n]);
    }
}

// 3 끝은 7가지가 있다. 
// ㅣ 두이 / 