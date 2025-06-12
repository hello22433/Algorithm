import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        // Please write your code here.

        int gcdVal = 0;
        if (n > m) {
            gcdVal = gcd(n, m);
        } else {
            gcdVal = gcd(m, n);
        }

        System.out.print(n*m / gcdVal);

        
    }

    public static int gcd(int n, int m) {
        if (n % m == 0) {
            return m;
        }

        return gcd(m, n%m);
    }
}