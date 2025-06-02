import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int cnt = 0;
        for (int i = 1; i <= n+n-1; i++) {
            for (int j = 0; j < cnt; j++) {
                System.out.print("  ");
            }
            for (int j = 0; j < n*2-1 - cnt*2; j++) {
                System.out.print("* ");
            }
            if (i<n) {
                cnt++;
            } else {
                cnt--;
            }
            System.out.println();
        }
    }
}
