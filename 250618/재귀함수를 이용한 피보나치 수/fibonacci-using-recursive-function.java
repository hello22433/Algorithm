import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.

        int num = pibonachi(n);
        System.out.print(num);
    }

    public static int pibonachi(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }

        return pibonachi(n-1) + pibonachi(n-2);
    }
}


//