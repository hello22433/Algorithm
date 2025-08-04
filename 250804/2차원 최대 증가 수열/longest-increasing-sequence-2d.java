import java.util.Scanner;
public class Main {

    // static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();
        // Please write your code here.

        int[][] dp = new int[n][m];


        dp[0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                
                if (dp[i][j] == 0) continue;

                for (int a = i+1; a < n; a++) {
                    for (int b = j+1; b < m; b++) {
                        if (grid[a][b] > grid[i][j]) {
                            dp[a][b] = dp[i][j] + 1;
                        }
                    }
                }
            }
        }

        int maxStep = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dp[i][j] != 0) maxStep = Math.max(maxStep, dp[i][j]);
            }
        }

        System.out.print(maxStep);
    }
}

// n m
// 0 0
// 오른쪽 and 아래 +1 이상 이동
// 수가 커야만 함.

// 0 0 부터 n-1 m-1 까지 가야 한다.
// 최대로 밟으려면 최대한 왼쪽 OR 최소한의 수 를 밟아야 한다.
// 하지만, 최소값과 왼쪽의 조화
// dp[i][j] : 0 0 부터 i j 까지의 최소값 XXXX
// dp[i][j] : 0 0 부터 i j 까지의 밟은 횟수
// 만약 이동하려고 하는데 전의 값보다 작거나 같다면, 이동할 수가 없음. 
// 칸을 정하고, 내려간다.
// INF 가 아닌 행렬값을 가진 격자 중에, 가장 큰 행에 있는 행에 +1을 한 게 곧 최대 점프 수다 

// 점프한 횟수를 적으면 되지 않을까? 어차피 값은 유지 되니까.