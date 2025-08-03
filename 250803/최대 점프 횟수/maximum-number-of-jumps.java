import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // Please write your code here.

        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int maxJumps = 0;

        // i : 이동하려는 곳
        // j : 출발하는 곳
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] + j >= i && dp[j] != Integer.MAX_VALUE) {
                    dp[i] = dp[j] + 1;
                    maxJumps = Math.max(maxJumps, dp[i]);
                }
            }
        }

        System.out.print(maxJumps);
    }
}

// dp[i] : 0부터 i까지 최대로 점프한 횟수
// arr[j] + j >= i 면, i로 이동할 수 있음.
// dp[i] = Math.max(dp[i], dp[j] + 1)