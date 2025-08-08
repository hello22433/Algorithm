import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 받기
        int n = sc.nextInt(); // 동전 개수
        int m = sc.nextInt(); // 목표 금액
        int[] coin = new int[n];
        for (int i = 0; i < n; i++) {
            coin[i] = sc.nextInt();
        }

        // INT_MIN 역할을 하는 값 설정
        int INT_MIN = Integer.MIN_VALUE;

        // dp 배열 초기화
        int[] dp = new int[m + 1];
        Arrays.fill(dp, INT_MIN);
        dp[0] = 0; // 금액 0을 만드는 데 필요한 동전 수는 0

        // dp 테이블 채우기
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j < n; j++) {
                if (i >= coin[j] && dp[i - coin[j]] != INT_MIN) {
                    dp[i] = Math.max(dp[i], dp[i - coin[j]] + 1);
                }
            }
        }

        // 결과 출력
        if (dp[m] == INT_MIN) {
            System.out.println(-1);
        } else {
            System.out.println(dp[m]);
        }

        sc.close();
    }
}
