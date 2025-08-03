import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        // Please write your code here.

        // 

        int maxVal = 1;
        int[] dp = new int[n];
        dp[0] = 1;

        for (int i = 1; i < n; i++) {

            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = dp[j] + 1;
                    maxVal = Math.max(maxVal, dp[i]);
                }
            }
        }

        System.out.print(maxVal);
    }
}

// N개의 숫자
// 가장 긴 증가 부분 수열의 길이
// 1 6 4 3 9 3
// 

// 9 1 2 3 
// dp[0] 
// dp[4]
// dp[i] : arr[i] 보다 작은 최소값에서 출발했을 때의 문장의 길이
// dp[0] : 1
// dp[1] : 1
// dp[2] : 2
// dp[3] : 3
// 만약 arr[j] 가 arr[i] 보다 작으면, dp[i]를 dp[j] + 1 로 갱신한다.