import java.util.Scanner;
public class Main {

    static int n;
    static int[] memo;
    static int moves = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        memo = new int[n+4];
        // Please write your code here.

        memo[0] = 1;
        f(0);
        System.out.print(moves%10007);
    }

    public static void f(int num) {
        
        // System.out.println(num);
        if (num == n)  {
            moves++;
            return;
        }
        if (num > n) return;

        if (memo[num+2] == 0 || num+2 == n) {
            memo[num+2] = 1;
            f(num+2);
        }
        if (memo[num+3] == 0 || num+3 == n) {
            memo[num+3] = 1;
            f(num+3);
        }
    }
}

// 2를 더하거나, 3을 더하거나 