import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.

        int[] dp = new int[n+1];

        dp[1] = 1;
        if (n >= 2) dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 10007;
        }

        System.out.print(dp[n]);
        
    }
}

// 1일때는 1
// 2일때는 2
// 3일때는 3
// 3일때 마지막 것이 ㅣ이거나 두이 자 이다.
// 즉, 2x3을 채울때는 남은 2x2를 채우거나 2x1을 채워야 한다.
// 2x4 를 채울 때는, 남은 2x3 2x2