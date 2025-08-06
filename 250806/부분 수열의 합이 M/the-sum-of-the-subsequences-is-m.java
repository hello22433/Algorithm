import java.util.Scanner;
public class Main {
    static int INF = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // Please write your code here.

        int[] dp = new int[m+1];

        for (int i = 1; i <= m; i++) {
            dp[i] = INF;
        }

        dp[0] = 0;

        for (int i = 0; i < n; i++) {

            for (int j = m; j >= 0; j--) {
                if (j - arr[i] < 0 || dp[j - arr[i]] == INF) continue;

                dp[j] = Math.min(dp[j], dp[j - arr[i]] + 1);
            }
        }

        if (dp[m] == INF) System.out.print(-1);
        else System.out.print(dp[m]);
    }
}

// 합이 M이 되는 경우 중, 가능한 최소 수열의 길이
// dp[i] : 합이 i가 되는 가장 작은 부분 수열의 길이
// 