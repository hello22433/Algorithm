import java.util.Scanner;

public class Main {
    static int maxValue = Integer.MIN_VALUE;
    static int n;
    static int[][] grid;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        // Please write your code here.

        dfs(0, Integer.MAX_VALUE);
        System.out.print(maxValue);
    }

    public static void dfs(int row, int minParam) {
        if (row == n) {
            maxValue = Math.max(maxValue, minParam);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (!visited[col]) {
                visited[col] = true;
                dfs(row+1, Math.min(grid[row][col], minParam));
                visited[col] = false;
            }
        }
    }
}


// 수들 중 최솟값 최대화
// N N
// 정확히 1개의 색칠된 칸만!
// 색칠된 칸 중, 최솟값이 최대가 되어야 한다.