import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] segments = new int[n][2];
        int[] dp = new int[n];
        // int[] line = new int[1001];

        for (int i = 0; i < n; i++) {
            segments[i][0] = sc.nextInt();
            segments[i][1] = sc.nextInt();
        }

        Arrays.sort(segments, (a,b) -> a[0]-b[0]);

        int maxLines = 1;
        for (int i = 0; i < n; i++) {

            dp[i] = 1;

            for (int j = 0; j < i; j++) {
                if (segments[j][1] < segments[i][0]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                    maxLines = Math.max(maxLines, dp[i]);
                }
            }
        }
        
        System.out.print(maxLines);
    }
}


// dp[i] : i 번째 선분을 마지막으로 했을 때, 겹치지 않는 가장 많은 수의 선분
// 