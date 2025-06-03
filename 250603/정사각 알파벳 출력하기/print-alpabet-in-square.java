import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // char x = sc.next().charAt(0);
        int n = sc.nextInt();

        int num = 65;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print((char) num++);
            }
            System.out.println();
        }
    }
}
