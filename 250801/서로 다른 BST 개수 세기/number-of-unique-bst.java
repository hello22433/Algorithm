import java.util.Scanner;
public class Main {

    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp = new int[n+1];
        // Please write your code here.

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {


            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i-j-1];
            }
        }

        System.out.print(dp[n]);

    }
}


// 2개 이하로 갖는다.
// 0개일때 1개, 1개일 때 1개, 2개일때는 왼쪽0 오른쪽1, 왼쪽1 오른쪽 0,
// 3개일 때는 왼쪽 0 오 2 / 1 1 / 2 1