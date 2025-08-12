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

        int maxProfit = 0;

        // 최댓값을 구하려면 모든 경우의 수를 다 구해보면 된다.
        // 길이가 4일때,
        // 안자름 : profit[4]
        // 1로 자름 : profit[1] + 길이 3일때 최적해
        // 2로 자름 : profit[2] + 길이 2일때 최적해
        // 3로 자름 : profit[3] + 길이 1일때 최적해
        // 그럼 각각의 길이일때의 최적해를 구해놓으면 되겠다.
        // dp[i] : 길이가 i일 때의 최적해
        // dp[0] = 0
        // dp[1] = profit[1]
        // dp[2] = profit[1] + dp[1] , profit[2]
        // dp[3] = profit[1] + dp[2], profit[2] + dp[1], profit[3]
        // dp[4] = profit[1] + dp[3], profit[2] + dp[2], profit[3] + dp[1], profit[4]
        // ...
        // cut은 1부터 시작해서 i까지 간다.
        // dp[i] = profit[cut] + dp[i - cut];

        for (int i = 1; i <= n; i++) {
            
            for (int cut = 1; cut <= i; cut++) {
                dp[i] = Math.max(dp[i], profit[cut] + dp[i - cut]);
                maxProfit = Math.max(maxProfit, dp[i]);
            }
        }
        

        System.out.print(maxProfit);
    }
}

// N
// 1부터 N까지 쪼갰을 때 파는 값. 
// 1로 쪼갰을때, 남은 것에 대해서 또 쪼개야 한다.
// 즉, n을 쪼갠 값 => profit[i] + (n - i 를 쪼갠 값)


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
//

// 최댓값을 구하려면 모든 경우의 수를 다 구해보면 된다.
// 길이가 4일때,
// 안자름 : profit[4]
// 1로 자름 : profit[1] + 길이 3일때 최적해
// 2로 자름 : profit[2] + 길이 2일때 최적해
// 3로 자름 : profit[3] + 길이 1일때 최적해
// 그럼 각각의 길이일때의 최적해를 구해놓으면 되겠다.
// dp[i] : 길이가 i일 때의 최적해
// dp[0] = 0
// dp[1] = profit[1]
// dp[2] = profit[1] + dp[1] , profit[2]
// dp[3] = profit[1] + dp[2], profit[2] + dp[1], profit[3]
// dp[4] = profit[1] + dp[3], profit[2] + dp[2], profit[3] + dp[1], profit[4]
// ...
// cut은 1부터 시작해서 i까지 간다.
// dp[i] = profit[cut] + dp[i - cut];

// 최대길이가 0일 때, dp[0]가 정답 
// 최대길이가 1일 때, dp[1]가 정답 
// 최대길이가 2일 때, dp[2]가 정답 -> 1로 쪼갠 값을 알아야 함. 즉, 최대길이 이하의 모든 값으로 쪼갠 값을 알아야 함.
// 중요한 점은 최대 길이보다 작은 모든 값으로 쪼갠 값을 알아야 한다는 것.
// 최대길이를 최대길이 이하의 모든 값으로 쪼개본다.
// dp[2]는 1과 2로 모두 쪼개보아야 한다.
// dp[i] = profit[i] + dp[n - i] 
// 

// 최대길이에 대해 1부터 쪼개볼까?
// 