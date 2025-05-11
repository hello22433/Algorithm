import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int minDistanceSum = Integer.MAX_VALUE;
        // Please write your code here.
        for (int i = 0; i < n; i++) {
            int selectHouseIdx = i;

            int distanceSum = 0;
            for (int j = 0; j < n; j++) {
                distanceSum += a[j] * Math.abs(j - selectHouseIdx);
            }
            minDistanceSum = Math.min(minDistanceSum, distanceSum);
        }
        System.out.print(minDistanceSum);
    }
}

// 