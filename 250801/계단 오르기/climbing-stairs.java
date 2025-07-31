import java.util.Scanner;

public class Main {
    public static final int MOD = 10007;
    public static int n;
    public static int[] memo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        memo = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            memo[i] = -1;  // 아직 계산 안 한 상태를 -1로 표시
        }

        memo[0] = 1;  // 0까지 가는 방법은 1가지
        if (n >= 1) memo[1] = 0;  // 1까지 가는 방법 없음
        if (n >= 2) memo[2] = 1;  // 2까지 가는 방법 1가지
        if (n >= 3) memo[3] = 1;  // 3까지 가는 방법 1가지

        System.out.print(f(n));
    }

    public static int f(int x) {
        if (x < 0) return 0;
        if (memo[x] != -1) return memo[x];

        memo[x] = (f(x - 2) + f(x - 3)) % MOD;
        return memo[x];
    }
}
