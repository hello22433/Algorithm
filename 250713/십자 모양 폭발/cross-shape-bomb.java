import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        int r = sc.nextInt()-1;
        int c = sc.nextInt()-1;
        // Please write your code here.

        int boomSize = grid[r][c];
        // 중심 푹발
        grid[r][c] = 0;

        // 위 폭발
        for (int i = 1; i < boomSize; i++) {
            if (r-i >= 0) 
                grid[r-i][c] = 0;
        }

        // 오 폭발
        for (int i = 1; i < boomSize; i++) {
            if (c+i < n)
                grid[r][c+i] = 0;
        }

        // 아 폭발
        for (int i = 1; i < boomSize; i++) {
            if (r+i < n)
                grid[r+i][c] = 0;
        }

        // 왼 폭발
        for (int i = 1; i < boomSize; i++) {
            if (c-i >= 0)
                grid[r][c-i] = 0;
        }

        for (int i = 0; i < n; i++) {
            int[] bucket = new int[n];
            int bucketIdx = 0;
            for (int j = n-1; j >= 0; j--) {
                if (grid[j][i] != 0) {
                    bucket[bucketIdx++] = grid[j][i];
                }
            }
            
            for (int j = n-1; j >= 0; j--) {
                grid[j][i] = bucket[n-1-j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
            
    }
}

// 해당 인덱스의 숫자를 확인한다.
// 숫자만큼 중심, 위오아왼을 0으로 만든다. 
// 

// 열을 순회하면서(0부터 n-1까지), 마지막 행부터 탐색한다. (n-1부터 0까지)
// 0이 아닌 값만 새로운 배열에 넣는다.
// 새로운 배열을 해당 열에 덮어씌운다.  