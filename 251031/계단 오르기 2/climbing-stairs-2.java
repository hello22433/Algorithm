import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] coins = new int[n+1];
        for (int i = 1; i <= n; i++) {
            coins[i] = sc.nextInt();
        }
        // Please write your code here.

        int[][] dp = new int[n+1][4];

        dp[0][0] = 0;

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= 3; j++) {

                if (i+2 <= n) {
                    dp[i+2][j] = Math.max(dp[i][j] + coins[i+2], dp[i+2][j]);
                }

                if (i+1 <= n && j <= 2) {
                    dp[i+1][j+1] = Math.max(dp[i][j] + coins[i+1], dp[i+1][j+1]);
                }
                 
            }
        } 
        int result = 0;
        for (int i = 0; i <= 2; i++) {
            // System.out.println(result);
            result = Math.max(result, dp[n][i]);
        }

        System.out.print(result);
        
    }
}

// n층
// 2또는 1
// 1은 최대 3개
// 동전을 가장 많이 먹는다
// 먹은 동전 (최대) 개수, 서있는 계단, 올라간 1계단 수
// o(0~1000) i(0~n) j(0,1,2,3)
// 1칸 올랐을 때, 0칸에서 올라온 경우 dp[1][0,1,2,3]
// 2칸 올랐을 때, 0칸 dp[2][0,1,2,3] / 1칸에서 올라온 경우(dp[2][0,1,2]에서 j가 3이 아닌 경우) -> j가 1을 더해야 함 dp[2][1,2,3]
// 