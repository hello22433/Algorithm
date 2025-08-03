import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // Please write your code here.

        int[] dp = new int[n];
        dp[0] = 1;
        int maxLength = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] < arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    maxLength = Math.max(maxLength, dp[i]);
                } else {
                    dp[i] = Math.max(dp[i], 1);
                }
            }
        }

        System.out.print(maxLength);
    }
}

// N개의 숫자
// 가장 긴 감소 부분 수열의 길이
// dp[i] : arr[i] 보다 작은 값에서 시작한 배열 중에 가장 긴 배열의 길이
// 