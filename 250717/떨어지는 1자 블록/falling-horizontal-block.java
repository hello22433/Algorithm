import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt()-1;
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        // Please write your code here.

        int hang = 0;
        outer: for (int i = 1; i < n; i++) {
            for (int j = k; j <= k+m-1; j++) {
                if (grid[i][j] == 1) {
                    hang = i-1;
                    break outer;
                }
            }
        }

        for (int j = k; j <= k+m-1; j++) {
            grid[hang][j] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}

// k 부터 (k + m-1) 열까지 차지한다.
// k 부터 (k + m-1) 열 중에 가장 위 쪽에 있는 격자를 찾는다.
// 그 격자의 행-1이 블럭이 놓이게될 행이 된다.
