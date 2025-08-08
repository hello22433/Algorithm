import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // Please write your code here.

        int[] dp = new int[m+1];
        int INF = Integer.MAX_VALUE;
        Arrays.fill(dp,INF);
        
        for (int j = 0; j < n; j++) {
            for (int i = m; i >= 0; i--) {
                if (i == arr[j] || (i - arr[j] >= 0 && dp[i - arr[j]] != INF)) {
                    dp[i] += 1;
                }
            }
        }

        if (dp[m] != INF) System.out.print("Yes");
        else System.out.print("No");
    }
}

// N개의 원소로 이루어진 수열 A
// A의 부분 수열 내 원소의 합이 M이 되어야 한다.
// dp[i] = i값이 되기 위한 부분 수열의 개수
// i == arr[j] || i - arr[j] != INF 
// dp[i] += 1;