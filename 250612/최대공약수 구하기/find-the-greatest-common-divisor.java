import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        // Please write your code here.
        
        if (n > m) {
            printGCD(n, m);
        } else {
            printGCD(m, n);
        }
    }

    public static int printGCD(int n, int m) {
        if (n % m == 0) {
            System.out.print(m);
            return 1;
        }
        return printGCD(m, n%m);
    }
}