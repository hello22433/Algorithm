import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.

        int[] dp = new int[n+1];

        int[] nums = {1,2,5};

        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            
            for (int j = 0; j < 3; j++) {
                if (i >= nums[j]) 
                    dp[i] = (dp[i] + dp[i - nums[j]]) % 10007;
            }
        }

        System.out.print(dp[n]);
    }
}

// dp[i] : 1,2,5의 합으로 i를 만들 수 있는 가짓수
// dp[0] = 0
// dp[1] = 1
// dp[2] = 2
// dp[3] = 3
// dp[4] = dp[3] + dp[1] + 2 * dp[2] + 4 * dp[1]
// 