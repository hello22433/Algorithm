import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x1 = new int[n];
        int[] x2 = new int[n];
        for (int i = 0; i < n; i++) {
            x1[i] = sc.nextInt();
            x2[i] = sc.nextInt();
        }
        // Please write your code here.

        outer : for (int point = 1; point <= 100; point++) {

            int haveCost = 1;
            for (int i = 0; i < n; i++) {
                if (x1[i] > point || point > x2[i]) {
                    if (haveCost == 1) {
                        haveCost--;
                    } else {
                        continue outer;
                    }
                }
            }
            System.out.print("Yes");
            return;
        }

        System.out.print("No");

    }
}

// 