import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }

        for (int i = 1; ; i++) {
            boolean check = true;
            int num = i*2;
            for (int j = 0; j < n; j++) {
                if (num < a[j] || num > b[j]) {
                    check = false;
                    break;
                }
                num *= 2;
            }
            if (check) {
                System.out.print(i);
                return;
            }
        }
    }
}

// 