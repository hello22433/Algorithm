import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[10];

        int sum1 = 0;
        int sum2 = 0;
        int cnt2 = 0;
        int ave = 0;
        for (int i = 0; i < 10; i += 2) {
            int num = sc.nextInt();
            if (num % 2 == 0) sum1 += num;
            if ((i+1) % 3 == 0) {
                sum2 += num;
                cnt2++;
            }
        }
        ave = sum2 / (double) cnt2;

        System.out.printf("%d %.1f", sum1, ave);
    }
}
