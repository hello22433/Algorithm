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

        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                minDistance = Math.min(minDistance, (int)Math.pow(x[i]-x[j],2) + (int)Math.pow(y[i]-y[j],2));
            }
        }

        System.out.print(minDistance);
    }
}

// 가장 가까운 두 점 사이의 거리의 제곱
// 가장 가까운 거리? 