import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = 0;
        int[] arr = new int[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
            m += arr[i];
        }
        // Please write your code here.

        boolean[][] dp = new boolean[n+1][m+1];

        dp[0][0] = true;

        for (int i = 1; i <= n; i++) {
            
            for (int j = 0; j <= m; j++) {
                if (j-arr[i] >= 0 && dp[i-1][j-arr[i]]) dp[i][j] = true;
                if (dp[i-1][j]) dp[i][j] = true;
            }
        }

        int minVal = Integer.MAX_VALUE;
        for (int i = 1; i <= m; i++) {
            if (dp[n][i]) {
                minVal = Math.min(minVal, Math.abs(i - (m - i)));
            }
        }

        System.out.print(minVal);
    }
}


// 합을 만들 것이고, 
// i번 째 수까지 고려했을 때, 합이 j가 된다면, j - (m - j) 가 그 차가 된다.
// 하나의 합만 구하면 된다. 
// dp[i][j] : i번째수까지 고려했을 때, j가 될 수 있는지?
// dp[0][0] 가능