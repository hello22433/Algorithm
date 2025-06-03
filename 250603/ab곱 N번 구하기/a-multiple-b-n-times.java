import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int mul = 1;
            int a = sc.nextInt();
            int b = sc.nextInt();

            for (int j = a; j <= b; j++) {
                mul *= j;
            }

            System.out.println(mul);
        }
    }
}
