import java.util.Scanner;
public class Main {
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.

        int[][][] dp = new int[n+1][3][3]; 

        dp[1][0][0] = 1;
        dp[1][0][1] = 1;
        dp[1][1][0] = 1;
        for (int r = 2; r <= n; r++) {
            for (int i = 0; i <= Math.min(2, r); i++) {
                for (int j = 0; j <= Math.min(2, r - i); j++) {
                    // t 선택
                    if (i>=1 && dp[r-1][i-1][j] != 0) dp[r][i][0] = (dp[r][i][0] + dp[r-1][i-1][j]) % MOD;

                    // b 선택
                    if (j>=1 && dp[r-1][i][j-1] != 0) dp[r][i][j] = (dp[r][i][j] + dp[r-1][i][j-1]) % MOD;

                    // g 선택
                    if (dp[r-1][i][j] != 0) dp[r][i][0] = (dp[r][i][0] + dp[r-1][i][j]) % MOD; 
                }
            }
        }

        int result = 0;
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                result = (result + dp[n][i][j]) % MOD;
            }
        }

        System.out.println(result);
    }
}

// 연속으로 B개 세번 아님 || T가 총합 세번 아님
// 필요정보 : 몇 번째 날인지, 총 T의 개수, 연속 B의 개수
// dp[r][i][j] = k (r번째 날에, T의 개수가 i개이고, B가 연속 j인 총 가지수 k)
// dp[1][0][0] = 1
// dp[1][0][1] = 1
// dp[1][1][0] = 1
// for (int r = 1; r <= n; r++) {
//    for (int i = 0; i <= Math.min(2, r); i++) {
//       for (int j = 0; j <= Math.min(2, r - i); j++) {
//          if (dp[r-1][i-1][j] != 0) dp[r][i][j] += dp[r-1][i-1][j];
//          if (dp[r-1][i][j-1] != 0) dp[r][i][j] += dp[r-1][i][j-1] 
//          if (dp[r-1][i][j] != 0) dp[r][i][j] += dp[r-1][i][j]
//       }
//    }
// }
// 이번 문자가 T인 경우 : if (dp[i-1][j] != 0) dp[i][j] += dp[i-1][j] 
// 이번 문자가 B인 경우 : if (dp[r-1][i][j-1] != 0) dp[r][i][j] += dp[r-1][i][j-1]
// 둘다 아닌 경우 : if (dp[r-1][i][j] != 0) dp[r][i][j] += dp[r-1][i][j]