import java.util.Scanner;

public class Main {

    static int[][] grid;
    static int n;
    static final int INF = Integer.MAX_VALUE;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        // Please write your code here.


        int result = INF;

        for (int low = 1; low <= 100; low++) {
            int high = findHigh(low);

            if (high != INF) // 불가능한 떄
                result = Math.min(result, Math.abs(high - low));
        }

        System.out.print(result);
    }

    public static int findHigh(int low) {
        int[][] dp = new int[n][n]; // dp[i][j] : 0,0 에서 i,j로 이동했을 때, 최댓값
        
        // 첫 값
        if (grid[0][0] < low) return INF;
        dp[0][0] = grid[0][0];

        // 첫 행
        for (int i = 1; i < n; i++) {
            if (dp[i-1][0] == INF || grid[i][0] < low) 
                dp[i][0] = INF;
            else 
                dp[i][0] = Math.max(dp[i-1][0], grid[i][0]);
        }

        // 첫 열
        for (int i = 1; i < n; i++) {
            if (dp[0][i-1] == INF || grid[0][i] < low) 
                dp[0][i] = INF;
            else 
                dp[0][i] = Math.max(dp[0][i-1], grid[0][i]);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                int fromTopMax = Math.max(dp[i-1][j], grid[i][j]);
                int fromLeftMax = Math.max(dp[i][j-1], grid[i][j]);


                if ((fromTopMax != INF || fromLeftMax != INF) && grid[i][j] >= low) 
                    dp[i][j] = Math.max(Math.min(fromTopMax, fromLeftMax), grid[i][j]);
                else 
                    dp[i][j] = INF;
            }
        }

        return dp[n-1][n-1];
    }
}