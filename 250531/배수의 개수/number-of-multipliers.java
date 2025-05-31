import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int th = 0;
        int fi = 0;
        for (int i = 1; i <= 10; i++) {
            int num = sc.nextInt();
            
            if (num % 3 == 0) {
                th++;
            } 

            if (num % 5 == 0) {
                fi++;
            }
            
        }
        System.out.print(th + " " + fi);

    }
}
