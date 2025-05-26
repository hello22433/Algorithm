import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.

        int[] x1 = new int[n];
        int[] x2 = new int[n];
        for (int i = 0; i < n; i++) {
            x1[i] = sc.nextInt();
            x2[i] = sc.nextInt();
        }

        outer : for (int num = 1; num <= 100; num++) {

            for (int i = 0; i < n; i++) {
                if (num > x2[i] || num < x1[i]) {
                    continue outer;
                }
            }
            System.out.print("Yes");
            return;
        }
        System.out.print("No");
    }
}

// 