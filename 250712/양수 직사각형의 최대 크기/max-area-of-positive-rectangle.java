import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();
        // Please write your code here.

        int maxSize = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = i; k < n; k++) {
                    lOuter : for (int l = j; l < n; l++) {
                        
                        aOuter : for (int a = i; a <= k; a++) {
                            for (int b = j; b <= l; b++) {
                                if (grid[a][b] <= 0) {
                                    continue lOuter;
                                }
                            }
                        }

                        maxSize = Math.max(maxSize, (k-i+1) * (l-j+1));
                    }
                }
            }
        }

        System.out.print(maxSize);
    }
}


// 문제 
// N x M 정수하나씩
// 가능한 양수 직사각형의 '최대'크기
// 모든 사각형이 양수
// 