import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            System.out.print(num * num + " ");
        }
    }
}
