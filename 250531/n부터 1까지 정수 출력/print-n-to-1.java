import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        while (a >= 1) {
            if (a%2==0)
            System.out.print(a + " ");
            a--;
        }
    }
}
