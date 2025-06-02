import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();


        int cnt = 1;
        for (int i = 2; i <= 8; i+=2) {
            for (int j = b; j >= a; j--) {
                System.out.printf("%d * %d = %d", j, i, i*j);
                if (j > a) System.out.print(" / ");
            }
            System.out.println();
        }


    }
}

