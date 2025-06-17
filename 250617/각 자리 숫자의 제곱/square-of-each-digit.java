import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.

        double powSum = makePowSum(n);
        System.out.print((int)powSum);
    }

    public static double makePowSum(int n) {
        if (n / 10 < 1) {
            return Math.pow(n % 10, 2);
        }

        return makePowSum(n / 10) + Math.pow(n % 10, 2);
    }
}