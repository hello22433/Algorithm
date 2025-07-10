import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        // Please write your code here.

        int maxSum = Integer.MIN_VALUE;

        // ㅡ
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m-2; j++) {
                maxSum = Math.max(maxSum, grid[i][j] + grid[i][j+1] + grid[i][j+2]);
            }
        }

        // ㅣ
        for (int i = 0; i < n-2; i++) {
            for (int j = 0; j < m; j++) {
                maxSum = Math.max(maxSum, grid[i][j] + grid[i+1][j] + grid[i+2][j]);
            }
        }

        // J
        for (int i = 0; i < n-1; i++) {
            for (int j = 1; j < m; j++) {
                maxSum = Math.max(maxSum, grid[i][j] + grid[i+1][j] + grid[i+1][j-1]);
            }
        }

        // ㄴ
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < m-1; j++) {
                maxSum = Math.max(maxSum, grid[i][j] + grid[i+1][j] + grid[i+1][j+1]);
            }
        }

        // ㄱ
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < m-1; j++) {
                maxSum = Math.max(maxSum, grid[i][j] + grid[i][j+1] + grid[i+1][j+1]);
            }
        }

        // r
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < m-1; j++) {
                maxSum = Math.max(maxSum, grid[i][j] + grid[i][j+1] + grid[i+1][j]);
            }
        }

        System.out.print(maxSum);
    }
}


// 문제
// 두 개의 블럭 중, 하나를 골라 자유롭게 회전하거나 뒤집어서, 자연수의 합을 최대화하라
// 

// 이해
// ㅡ는 ㅡ와 ㅣ만 가능
// ㄱ는 십자가 가능.
// 그럼 각 경우에 대해 완전탐색 구현 가능.