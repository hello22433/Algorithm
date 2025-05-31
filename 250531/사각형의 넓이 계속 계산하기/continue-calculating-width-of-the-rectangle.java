import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int sumVal = 0;
        while (true) {
            int width = sc.nextInt();
            int length = sc.nextInt();
            char c = sc.next().charAt(0);

            System.out.println(width * length);
            if (c == 'C') break;
            
        }
    }
}
