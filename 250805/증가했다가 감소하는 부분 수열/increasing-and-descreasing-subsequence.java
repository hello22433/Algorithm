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

        int[] dpInc = new int[n];
        int[] dpDec = new int[n];


        for (int i = 0; i < n; i++) {
            dpInc[i] = 1;

            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dpInc[i] = Math.max(dpInc[i], dpInc[j] + 1);
                }
            }
        }

        for (int i = n-1; i >= 0; i--) {
            dpDec[i] = 1;

            for (int j = n-1; j > i; j--) {
                if (arr[i] > arr[j]) {
                    dpDec[i] = Math.max(dpDec[i], dpDec[j]+1);
                }
            }
        }


        int maxLen = 1;
        for (int i = 0; i < n; i++) {
            maxLen = Math.max(maxLen, dpInc[i] + dpDec[i] - 1);
        }
        System.out.print(maxLen);
    }
}

// N 개의 숫자가 주어짐
// 가장 긴, 증가-감소 부분 수열
// 계속 증가 -> 계속 감소 : 증가 부분 수열 OR 감소 부분 수열 포함
// 

// dp[i] : i를 기준으로 가장 긴 증가감소부분수열의 길이
// 증가부분수열의 길이
// 감소부분수열의 길이
// 
// 증가 : dpIncre : i까지 증가
// 감소 : dpDecre : i부터 감소