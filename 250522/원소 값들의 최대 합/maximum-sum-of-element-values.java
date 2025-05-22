import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        int maxSum = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            int startAndNextIdx = i;

            int sum = 0;
            for (int j = 0; j < m; j++) {
                sum += arr[startAndNextIdx];
                startAndNextIdx = arr[startAndNextIdx];
            }
            maxSum = Math.max(maxSum, sum);
        }

        System.out.print(maxSum);
    }
}

// M번 움직임 했을때 원소값들의합 이 최대가 되어야 한다.
// 시작값을 1부터 N까지 고른다. startAndNextIdx = i
// m번만큼 밑의 계산을 반복한다.
// arr[startAndNextIdx]의 값을 startAndNextIdx 저장한다. 저장 전에 값을 합한다..
// 반복이 끝나면 최대값을 갱신한다.