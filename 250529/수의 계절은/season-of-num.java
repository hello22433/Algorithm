import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();

        if (a == 12|| a <= 2) {
            System.out.println("Winter");
        }
        else if (a <= 5) {
            System.out.println("Spring");
        }else if (a <= 8) {
            System.out.println("Summer");
        }else {
            System.out.println("Fall");
        }
    }
}
