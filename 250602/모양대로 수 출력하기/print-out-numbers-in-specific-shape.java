import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= n-i; j++) {
                System.out.printf("  ");
            }
            for (int j = i; j >= 1; j--) {
                System.out.printf("%d ", j);
            }
            System.out.println();
        }


    }
}

