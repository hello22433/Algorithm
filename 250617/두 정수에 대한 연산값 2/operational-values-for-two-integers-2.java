import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        // Please write your code here.

        int[] ab = cal(a, b);

        System.out.print(ab[0] + " " + ab[1]);
    }

    public static int[] cal(int a, int b) {
        if (a > b) {
            a *= 2;
            b += 10;
        } else {
            b *= 2;
            a += 10;
        }
        return new int[]{a,b};
    }
}