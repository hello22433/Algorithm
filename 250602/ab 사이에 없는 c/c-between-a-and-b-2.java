import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        boolean satisfied = true;
        for (int i = a; i <= b; i++) {
            if (i >= c && i % c == 0) {
                satisfied = false; // 배수가 있음 -> false
            }
        }
        if (satisfied == true) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }
}
