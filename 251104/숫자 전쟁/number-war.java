import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }

        int[][] dp = new int[n + 1][n + 1];

        // 뒤에서부터 계산 (a[i], b[j] 남았을 때)
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                // 1️⃣ 둘 다 버리기
                dp[i][j] = dp[i + 1][j + 1];

                // 2️⃣ a < b : 남우 점수 += b[j], a 버리기
                if (a[i] < b[j]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i + 1][j]);
                }

                // 3️⃣ a > b : b 버리기
                if (a[i] > b[j]) {
                    dp[i][j] = Math.max(dp[i][j], b[j] + dp[i][j + 1]);
                }
            }
        }

        System.out.println(dp[0][0]);
        
    }
}

// a<b : 남우점수 += a , a버림(a인덱스+1)
// a=b : a,b버림(a인덱스+1, b인덱스+1)
// 남우는 두 번째 플레이어

// 남아있는 첫번째 덱의 수(가리키는 카드 번호), 남아있는 두번째 덱의 수(동일), 남우의 점수, 상대방의 점수
// i j dp[i][j]:Max
// 
// 둘다 버리거나, 비교하거나
// 모두 고려해야 한다. 
// 만약 전에 경우가 존재한다면 가능하다
// dp[0][0] = 0 
// dp[1][0] = a의 0을 버렸다는 뜻이니까 a[0]<b[0]
// 즉, 현재 반복의 인덱스가 더 작고, 전의 값이 있으면 버릴 수 있다는 뜻이다.
// 