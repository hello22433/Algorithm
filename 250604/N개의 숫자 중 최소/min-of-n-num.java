import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        int n = sc.nextInt();
        int min = Integer.MAX_VALUE;
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            int num = sc.nextInt();
            if (min == num) {
                cnt++;
            } else {
                min = Math.min(min, num);
            }
        }
        System.out.print(min + " " + cnt);
    }
}
