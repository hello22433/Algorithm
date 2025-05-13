import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        // Please write your code here.

        int min = Integer.MAX_VALUE;
        for (int i = 1; i < n-1; i++) {
            int minBucket = 0;
            int curX = x[0];
            int curY = y[0];
            for (int j = 0; j < n; j++) {
                if (j == i) continue;
                minBucket += Math.abs(x[j] - curX) + Math.abs(y[j] - curY);
                curX = x[j];
                curY = y[j];
            }
            min = Math.min(min, minBucket);
        }
        System.out.print(min);
    }
}

// 처음과 마지막 체크포인트는 건너뛰지 않을 것
// 하나 건너 뛰고 최소거리 구하기
// 체크포인트가 겹쳐져 있을 때는 그 번호의 체크포인트만 건너뛰는 것임
// 