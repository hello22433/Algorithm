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

        int maxValue = Integer.MIN_VALUE;

        for (int i = 0; i < n ; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    maxValue = Math.max(maxValue, arr[i] * arr[j] * arr[k]);
                }
            }
        }
        System.out.print(maxValue);
    }
}


// 문제
// 정수 N과 N개의 수.

// 요구사항
// 3개의 수를 적절하게 골라 나올 수 있는 곱 중 '최대값'을 구해라

// 이해
// 음수끼리
// 양수끼리
// 음수가 나올 수도 있음. -> 절대값이 작아야 함


// 구현
// 3개의 수를 적절하게 고른다 -> 곱을 구한다. -> 최대값 갱신한다. 