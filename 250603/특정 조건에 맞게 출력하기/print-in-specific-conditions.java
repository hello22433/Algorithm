import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        

        while (true) {
            int num = sc.nextInt();

            if (num == 0) break;
            if (num % 2 != 0) {
                System.out.print(num+3 + " ");
            } else {
                System.out.print(num/2 + " ");
            }
        }

        
    }
}
