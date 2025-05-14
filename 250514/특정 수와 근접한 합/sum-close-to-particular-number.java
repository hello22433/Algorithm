import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int S = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        // S와의 차의 절대값이 가장 작은 경우 -> 그 차이를 출력한다.
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                int sum = 0;
                for (int k = 0; k < N; k++) {
                    if (k == i || k == j) continue;
                    sum += arr[k];
                }
                minDiff = Math.min(minDiff, Math.abs(S-sum));
            }
        }
        System.out.print(minDiff);
    }
}


// 