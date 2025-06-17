import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.

        oneToN(n);
        System.out.println();
        nToOne(n);
    }

    public static void oneToN(int n) {
        if (n == 0) return;

        oneToN(n - 1);
        System.out.print(n + " ");
    } 

    public static void nToOne(int n) {
        if (n == 0) return;

        System.out.print(n + " ");
        nToOne(n - 1);
    }
}