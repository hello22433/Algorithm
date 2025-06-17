import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.

        int cnt = cntCalculator(n);
        System.out.print(cnt);
    }

    public static int cntCalculator(int n) {
        if (n == 1) return 0;

        if (n % 2 == 0) {
            n/=2;
        } else {
            n/=3;
        }
        return cntCalculator(n)+1;
    }
}