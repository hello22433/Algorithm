import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Please write your code here.
        int A = sc.nextInt();
        int B = sc.nextInt();

        int cnt = 0;
        for (int i = A; i <= B; i++) {
            if (isOnjeonsu(i)) {
                cnt++;
            }
        }
        System.out.print(cnt);
    }

    public static boolean isOnjeonsu(int num) {
        if (num % 2 == 0) {
            return false;
        }
        if (num % 10 == 5) {
            return false;
        }
        if (num % 3 == 0 && num % 9 != 0) {
            return false;
        }
        return true;
    }
}