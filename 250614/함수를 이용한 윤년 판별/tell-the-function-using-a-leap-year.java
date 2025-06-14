import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt();
        // Please write your code here.

        if (isYoonNyeon(y)) {
            System.out.print("true");
        } else {
            System.out.print("false");
        }
    }

    public static boolean isYoonNyeon(int num) {
        if (num % 4 != 0) {
            return false;
        }
        if (num % 100 == 0 && num % 400 != 0) {
            return false;
        }
        return true;
    }
}