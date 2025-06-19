import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.

        System.out.print(cal(n, 0));
    }

    public static int cal(int n, int cnt) {
        if (n==1) return cnt;

        int result = 0;
        if (n % 2 == 0) {
            result = cal(n/2, cnt+1);
        } else {
            result = cal(n*3+1, cnt+1);
        }
        return result;
    }
}