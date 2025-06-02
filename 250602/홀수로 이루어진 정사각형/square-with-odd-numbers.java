import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            int iVal = i*2-1+10;
            for (int j = 1; j <= n; j++) {
                System.out.printf("%d ",iVal);
                iVal+=2;
            }
            System.out.println();
        }

    }
}

