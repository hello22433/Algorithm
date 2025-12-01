import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] dp = new int[2*n + 1][n + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        dp[0][0] = 0;

        for (int round = 1; round < 2 * n + 1; round++) {
            int red = sc.nextInt();
            int blue = sc.nextInt();

            for (int redCnt = 0; redCnt <= n; redCnt++) {

                if (dp[round-1][redCnt] != -1) {
                    dp[round][redCnt] = Math.max(dp[round][redCnt], dp[round-1][redCnt] + blue);
                }

                if (redCnt >= 1 && dp[round-1][redCnt-1] != -1) {
                    dp[round][redCnt] = Math.max(dp[round][redCnt], dp[round-1][redCnt-1] + red);
                }
            }
        }
        
        System.out.print(dp[2*n][n]);
    }
}


// 매 시행마다 카드를 (빨)N + (파)N 개 골라서 숫자합을 최대화
// 
// 필요한 정보
// 뽑힌 빨강 카드 개수, 뽑힌 파랑 카드 개수 (i, j, i<=N and j<=N)
// dp[k][i] : i개의 빨강 카드와 j(2*n - i)개의 파랑 카드가 뽑혔을 때의 최댓값
// 1라운드씩 증가하면서 각각의 카드를 뽑았을 때의 최대값을 갱신한다.
