import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] profit = new int[n+1];
        for (int i = 1; i <= n; i++) {
            profit[i] = sc.nextInt();
        }
        // Please write your code here.
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = profit[1];
        dp[2] = Math.max(profit[1] * 2, profit[2]);
        int maxProfit = 0;

        for (int i = 3; i < n+1; i++) {
            dp[i] = Math.max(dp[i-1] + profit[1], profit[i]);
            if (i % 2 == 0) dp[i] = Math.max(dp[i], profit[i/2] + profit[i/2]);
            maxProfit = Math.max(maxProfit, dp[i]);
            // System.out.println(dp[i]);
        }

        System.out.print(maxProfit);
    }
}

// N
// 1부터 N까지 쪼갰을 때 파는 값. 
// 1로 쪼갰을때, 남은 것에 대해서 또 쪼개야 한다.
// 즉, n을 쪼갠 값 => profit[i] + (n - i 를 쪼갠 값)



// dp[n] : 길이가 n일때 수익의 최대값
// 길이가 0일 때는 무조건 수익이 0
// dp[1] = 길이가 1일 때는 무조건 수익이 profit[1]
// dp[2] = 길이가 2일때는 무조건 수익이 profit[1]*2 OR profit[2]
// dp[3] = 길이가 3일때는 무조건 수익이 profit[1]*3 OR profit[2]+profit[1] OR profit[3]
// dp[4] = 길이가 4일때는 무조건 수익이 profit[1]*4 OR profit[3]+profit[1] OR profit[2]+profit[2] OR profit[4]
// dp[2] = dp[1] * 2 OR profit[2]
// dp[3] = dp[1] * 3 OR dp[2]+dp[1] OR profit[3] // dp[2]에서 이미 dp[1] * 2를 고려했기 때문에 
// dp[2] + dp[1] 만 고려하면 됨. 즉, Math.max(dp[i - 1] + dp[i - 2], profit[3])
// 






// dp[n] : n으로 하나를 쪼갠 최댓값

// 0으로 쪼갠 최댓값
// dp[0] = profit[0] + n-0을 쪼갠 최댓값

// dp[1] = profit[1] + n-1
// dp[2] = profit[2] + n-2
// ...
// dp[n-2] = profit[n-2] + n-(n-2) : 길이 2를 고려한 값 : profit[2]
// dp[n-1] = profit[n-1] + n-(n-1) : 길이 1을 고려한 값 : profit[1]
// dp[n] = profit[n] + n-n


// N이 4인 경우
// dp[0] = 0 + dp[4]
// dp[1] = profit[1] + dp[3]
// dp[2] = profit[2] + dp[2]
// dp[3] = profit[3] + dp[1] 
// dp[4] = profit[4] + dp[0] (확정)

// dp[i][j] : i로 쪼갤때의, 최대 길이가 j일 때, 이익의 최댓값
// dp[1][1] = 1을 1로 쪼개면 profit[1], 
// dp[1][2] = 2를 1로 쪼개면 dp[1] + profit[2] 
// dp[1][3] = 3을 1로 쪼개면 dp[2] +  profit[3]
// ...
// dp[2][1] = 1을 2로 쪼갠다 
// dp[2][2] = 2를 2로 쪼갠다 dp[2][0] + profit[2]
// dp[2][3] = 3을 2로 쪼갠다 dp[2][3 - 2] + 