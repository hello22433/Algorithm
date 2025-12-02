import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }
        // Please write your code here.

        int[][] dp = new int[N][41];

        if (numbers[0] >= -20 && numbers[0] <= 20) {
            dp[0][numbers[0] + 20] = 1;
        }

        if (numbers[0] >= -20 && numbers[0] <= 20) {
            dp[0][20 - numbers[0]] = 1;
        }

        for (int i = 1; i < N; i++) {
            
            // 전 항까지의 가지 수 + 
            for (int j = 0; j <= 40; j++) {

                // 그 전 가지수가 없으면 (도달이 불가능했다면) 
                // 그 수에서 확장이 불가능함
                if (dp[i-1][j] == 0) continue;

                // 
                int curNum = j-20;
                int nextNum = numbers[i];

                int sumPlus = curNum + nextNum;
                if (sumPlus <= 20 && sumPlus >= -20) {

                    dp[i][sumPlus + 20] += dp[i-1][j];
                }


                int sumMinus = curNum - nextNum;
                if (sumMinus <= 20 && sumMinus >= -20) {

                    dp[i][sumMinus + 20] += dp[i-1][j];
                }
            }
        }

        System.out.print(dp[N-1][M + 20]);
    }
}

// 더하고 빼는 경우의 수
// 1) 항의 위치
// 2) 그 항까지의 합
// 
// dp[i : 항의 위치][j : 그 항까지의 합] : i항까지 j합인 가지수
// 