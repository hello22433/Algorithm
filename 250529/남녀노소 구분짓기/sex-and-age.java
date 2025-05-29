import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int a = sc.nextInt();

        if (s == 0) {
            if (a >= 19) {
                System.out.println("MAN");
            }
            else {
                System.out.println("BOY");
            }
        }
        else {
            if (a >= 19) {
                System.out.println("WOMAN");
            }
            else {
                System.out.println("GIRL");
            }
        }
    }
}
