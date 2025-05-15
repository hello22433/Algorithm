import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int h = sc.nextInt();
        int t = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int minDifferSum = Integer.MAX_VALUE;
        for (int i = 0; i <= n-t; i++) {
            int diffSum = 0;
            for (int j = 0; j < t; j++) {
                diffSum += Math.abs(h - arr[i+j]);
            }
            minDifferSum = Math.min(minDifferSum, diffSum);
        }
        System.out.print(minDifferSum);
    }
}

// N개 중 T개를 H높이로 맞추어야 함
// 시작점을 고르고 3개를 뽑는다.
// 각각을 H에서 뺀다. 
// 뺀값의 합이 비용이다.
// 최소비용을 구한다.