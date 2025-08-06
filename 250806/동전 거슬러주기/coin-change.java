import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] coin = new int[n];
        for (int i = 0; i < n; i++)
            coin[i] = sc.nextInt();
        // Please write your code here.

        int[] dp = new int[m+1];

        for (int i = 0; i < m+1; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        dp[0] = 0;

        for (int i = 1; i <= m; i++) {

            for (int j = 0; j < n; j++) {
                if (i - coin[j] < 0 || dp[i - coin[j]] == Integer.MAX_VALUE) continue;

                dp[i] = Math.min(dp[i], dp[i - coin[j]] + 1);
            }
        }

        if (dp[m] == Integer.MAX_VALUE) System.out.print(-1);
        else System.out.print(dp[m]);
    }
}


// N 개의 동전 종류
// M을 거슬러주어야 한다.
// 필요한 최소 동전의 수
// 같은 종류 동전 여러번 사용 가능

// dp[i] : i원을 만들기 위한, 최소 동전 수