import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        int[] bombColsIdxes = new int[m];
        for (int i = 0; i < m; i++) 
            bombColsIdxes[i] = sc.nextInt()-1;
        // Please write your code here.

        for (int t = 0; t < m; t++) {
            int r = -1;
            int c = bombColsIdxes[0];
            
            for (int i = 0; i < n; i++) {
                if (grid[i][c] != 0) {
                    r = i;
                    break;
                }
            }

            if (r != -1) {
                int boomSize = grid[r][c];

                grid[r][c] = 0;
                // u
                for (int i = 1; i < boomSize; i++) {
                    if (r-i >= 0)
                        grid[r-i][c] = 0;
                }
                // r
                for (int i = 1; i < boomSize; i++) {
                    if (c+i < n)
                        grid[r][c+i] = 0;
                }
                // d
                for (int i = 1; i < boomSize; i++) {
                    if (r+i < n)
                        grid[r+i][c] = 0;
                }
                // l
                for (int i = 1; i < boomSize; i++) {
                    if (c-i >= 0)
                        grid[r][c-i] = 0;
                }

                // 중력으로 내린다.
                for (int i = 0; i < n; i++) {
                    int[] bucket = new int[n];
                    int bucketIdx = 0;
                    for (int j = n-1; j >= 0; j--) {
                        if (grid[j][i] != 0) bucket[bucketIdx++] = grid[j][i];
                    }
                    for (int j = n-1; j >= 0; j--) {
                        grid[j][i] = bucket[n-1-j];
                    }
                }
            } else {
                continue;
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


// 열에서 하나씩 내려가면서 숫자를 찾는다.
// 만약 0이 아닌 값을 발견하면 해당 수에 맞는 범위를 터뜨린다.
// 중심을 터뜨리고 r c 값 -1만큼 위r+i 오c+i 아r-i 왼c-i 를 0으로 만든다.
// 모두 아래로 내린다.