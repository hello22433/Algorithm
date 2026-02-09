import java.util.Scanner;

public class Main {
    static final long INF = 1_000_000_000_000L;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 현재값의 인덱스, 현재 구간은 몇 개인가, 현재값을 쓸것인가 안쓸것인가, i j k
        // 구간 합의 최댓값

        long[][][] dp = new long[n][m+1][2];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m+1; j++) {
                dp[i][j][0] = -INF;
                dp[i][j][1] = -INF;
            }
        }

        dp[0][0][0] = 0;
        dp[0][1][1] = arr[0];

        for (int i = 1; i < n; i++) {

            dp[i][0][0] = 0;
            
            for (int j = 1; j <= m; j++) {

                // 현재 숫자를 선택하지 않는다.
                // 전의 숫자를 선택했든, 선택하지 않았던 그대로 최댓값을 가져온다. 구간은 늘어나지 않는다.
                dp[i][j][0] = Math.max(dp[i-1][j][1], dp[i-1][j][0]);


                // 현재 숫자를 선택한다.
                // 구간이 하나 늘어나는 것이므로 j-1에서 가져와야 한다. 
                // 전의 숫자를 선택했다면 연장, 아니라면 새로출발이다.
                dp[i][j][1] = Math.max(dp[i-1][j][1] + arr[i], dp[i-1][j-1][0] + arr[i]);

            }
        }

        System.out.print(Math.max(dp[n-1][m][0], dp[n-1][m][1]));
    }
}
