import java.util.Scanner;

public class Main {

    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        int[][] minDP = new int[n][n];
        int[][] maxDP = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        // Please write your code here.

        minDP[0][0] = grid[0][0];
        maxDP[0][0] = grid[0][0];

        for (int i = 1; i < n; i++) {
            minDP[i][0] = Math.min(minDP[i-1][0], grid[i][0]);
            minDP[0][i] = Math.min(minDP[0][i-1], grid[0][i]);
            maxDP[i][0] = Math.max(maxDP[i-1][0], grid[i][0]);
            maxDP[0][i] = Math.max(maxDP[0][i-1], grid[0][i]);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {

                int fromTopMinValue = Math.min(minDP[i-1][j], grid[i][j]);
                int fromTopMaxValue = Math.max(maxDP[i-1][j], grid[i][j]);
                int diffFromTop = fromTopMaxValue - fromTopMinValue;

                int fromLeftMinValue = Math.min(minDP[i][j-1], grid[i][j]);
                int fromLeftMaxValue = Math.max(maxDP[i][j-1], grid[i][j]);
                int diffFromLeft = fromLeftMaxValue - fromLeftMinValue;

                if (diffFromLeft < diffFromTop) {
                    minDP[i][j] = fromLeftMinValue;
                    maxDP[i][j] = fromLeftMaxValue;
                } else {
                    minDP[i][j] = fromTopMinValue;
                    maxDP[i][j] = fromTopMaxValue;
                }             
            }
        }

        System.out.print(maxDP[n-1][n-1] - minDP[n-1][n-1]);
    }
}


// 최소값, 최대값 DP를 따로만들고, 차이를 계산해서 차이가 가장 큰 경우에(위에서 오는 차이, 왼쪽에서 오는 차이중에 더 작은 경우)
// 