import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] weight = new int[n+1];
        int[] value = new int[n+1];
        for (int i = 1; i <= n; i++) {
            weight[i] = sc.nextInt();
            value[i] = sc.nextInt();
        }

        int[][] dp = new int[n+1][m+1];

        for (int i = 1; i <= n; i++) {

            for (int w = 0; w <= m; w++) {
                if (w-weight[i] >= 0)
                    dp[i][w] = Math.max(dp[i-1][w], dp[i][w-weight[i]] + value[i]);
                else 
                    dp[i][w] = dp[i-1][w];
            }
        }

        System.out.print(dp[n][m]);
    }
}

// N개의 보석의 정보
// M넘지 않고
// 가치가 최대
// 동일 보석을 여러개 고르기 가능
// 

// dp[i][w] i개 까지 고려했을때, 최대무게가 w일 때의 최댓값