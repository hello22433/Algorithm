import java.util.Scanner;
public class Main {
    static int n, m;
    static int[][] grid;

    // 동 동남 남 남서 서 서북 북 북동 0 1 2 3 4 5 6 7
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        // Please write your code here.

        for (int t = 0; t < m; t++) {
            simulateMoves();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void simulateMoves() {
        for (int i = 1; i <= n*n; i++) {
            simulateMove(i);
        }
    }

    public static void simulateMove(int num) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == num) {
                    int[] maxValueXY = findMaxValueXY(i, j);
                    int nx = maxValueXY[0];
                    int ny = maxValueXY[1];

                    int tmp = grid[i][j];
                    grid[i][j] = grid[nx][ny];
                    grid[nx][ny] = tmp;

                    return;
                }
            }
        }
    }

    public static int[] findMaxValueXY(int x, int y) {
        int maxValue = 0;
        int[] maxValueIdx = new int[2];
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (isInBound(nx, ny) && maxValue < grid[nx][ny]) {
                maxValue = Math.max(maxValue, grid[nx][ny]);
                maxValueIdx = new int[]{nx, ny}; 
            }
        }
        return maxValueIdx;
    }

    public static boolean isInBound(int x, int y) {
        if (x >= 0 && x < n && y >= 0 && y < n) return true;
        return false;
    }
}


// 1