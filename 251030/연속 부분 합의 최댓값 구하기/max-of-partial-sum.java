import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        // Please write your code here.
        // 부분수열의 합
        // dp[i] = i번째 까지 고려했을 때, 부분수열의 최대 합
        // 그전 꺼를 써서 이어가던가, 아니면 처음 시작하던가
        // dp[i] = Math.max(dp[i-1] + nums[i], nums[i])
        // result = Math.max(result, dp[i])
        int result = Integer.MIN_VALUE;
        int[] dp = new int[n+1];

        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);

            result = Math.max(result,dp[i]);
        }

        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);

            result = Math.max(result,dp[i]);
        }

        System.out.println(result);
        
    }
}