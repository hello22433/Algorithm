import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < n-2; i++) {
            for (int j = 0; j < n-2; j++) {

                int bucketSum = 0;
                for (int a = i; a <= i+2; a++) {
                    for (int b = j; b <= j+2; b++) {
                        bucketSum += grid[a][b];
                    }
                }
                maxSum = Math.max(bucketSum, maxSum);
            }
        }

        System.out.print(maxSum);
    }
}