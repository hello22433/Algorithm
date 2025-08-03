import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        // Please write your code here.

        int[][] dp = new int[n][n];

        dp[0][0] = matrix[0][0];

        // 첫 행
        for (int i = 1; i < n; i++) {
            dp[0][i] = Math.max(dp[0][i-1], matrix[0][i]);
        }

        // 첫 열
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], matrix[i][0]);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                int fromTop = Math.max(dp[i-1][j], matrix[i][j]);
                int fromLeft = Math.max(dp[i][j-1], matrix[i][j]);
                
                dp[i][j] = Math.min(fromTop, fromLeft);
            }
        }

        System.out.print(dp[n-1][n-1]);
    }
}

// N N
// 00 오른쪽,밑
// 거쳐간 위치에 적혀있는 숫자들 중 최댓값을 최소로 하라!
// 최댓값을 찾는 DP : 오른쪽이나 밑쪽으로 갈떄, 최댓값을 갱신하면서 내려가면 된다.
// 근데 그 중에, 위와 왼쪽에서 오는 경로 중에서 더 작은 경로를 택해서, 현재 값과 비교해 최댓값을 갱신한다.
// 즉 dp[i][j] : 00에서 시작해서 ij 에 올때, 최소인 최댓값
// 