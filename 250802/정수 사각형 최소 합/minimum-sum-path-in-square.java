import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                matrix[i][j] = sc.nextInt();
        // Please write your code here.

        dp[0][n-1] = matrix[0][n-1];

        for (int i = n-2; i >= 0; i--) {
            dp[0][i] = dp[0][i+1] + matrix[0][i];

            dp[n-1-i][n-1] = dp[n-1-i-1][n-1] + matrix[n-1-i][n-1];
        }

        for (int i = 1; i < n; i++) {
            for (int j = n-2; j >= 0; j--) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j+1]) + matrix[i][j];
            }
        }

        System.out.print(dp[n-1][0]);
    }
}


// 0 n-1 , n-1 0