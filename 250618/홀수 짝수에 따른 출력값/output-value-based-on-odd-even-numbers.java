import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.

        int sum = 0;
        if (n % 2 != 0) {
            sum = makeSumIfOdd(n);
        } else {
            sum = makeSumIfEven(n);
        }
        System.out.print(sum);
    }

    public static int makeSumIfOdd(int n) {
        if (n == 1) return 1;

        if (n % 2 != 0) {
            return n + makeSumIfOdd(n-1);
        } else {
            return makeSumIfOdd(n-1);
        }
    }

    public static int makeSumIfEven(int n) {
        if (n == 2) return 2;

        if (n % 2 == 0) {
            return n + makeSumIfEven(n-1);
        } else {
            return makeSumIfEven(n-1);
        }
    }
}