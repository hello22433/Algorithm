import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         

        int n = sc.nextInt();

        int twoCnt = 0;
        for (int i = 1; i <= n; i++) {
            if (sc.nextInt() == 2) {
                twoCnt++;
            }
            if (twoCnt == 3) {
                System.out.print(i);
                return;
            }
        }
    }
}
