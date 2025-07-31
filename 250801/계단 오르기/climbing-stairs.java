import java.util.Scanner;
public class Main {
    static int n;
    static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        // Please write your code here.



        dp = new int[n+4];
        dp[0] = 1;
        memorization(0);

        System.out.print(dp[n]);
    }

    public static void memorization(int num) {

        if (num >= n){
            return;
        }

        dp[num+2] += dp[num]%10007;
        dp[num+3] += dp[num]%10007;

        memorization(num+2);
        memorization(num+3);
    }
}