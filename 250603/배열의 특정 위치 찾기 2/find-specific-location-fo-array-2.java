import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[10];

        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < 10; i++) {
            arr[i] = sc.nextInt();
            if ((i+1) % 2 != 0) {
                sum1 += arr[i];
            } else {
                sum2 += arr[i];
            }
        }
        System.out.print(Math.abs(sum1 - sum2));
    }
}
