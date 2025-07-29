import java.util.Scanner;
public class Main {
    static int n;
    static int[][] grid;
    static boolean[] visitedX;
    static boolean[] visitedY;
    static int maxSum = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        visitedX = new boolean[n];
        visitedY = new boolean[n];
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        // Please write your code here.
        
        dfs(0, 0);
        System.out.print(maxSum);
    }

    public static void dfs(int depth, int sum) {

        if (depth == n) {
            maxSum = Math.max(maxSum, sum);
            return;
        }

        for (int j = 0; j < n; j++) {
            if (visitedY[j]) continue;

            visitedY[j] = true;

            dfs(depth+1, sum+grid[depth][j]);

            visitedY[j] = false;
        }
    }
}


// N N  각 칸에 정수
// 정확히 N개에 색칠
// 각 행과 열에 정확히 1개의 색칠된 칸만 와야 한다.
// 색칠된 칸에 적힌 수들의 합 중, 가능한 최댓값


// 행마다 하나
// 열마다 하나
// 방문행, 방문열을 체크한다.
// 
// 행을 하나 고르고 열을 고른다.
// n개 고르면 합을 최대값 갱신한다.