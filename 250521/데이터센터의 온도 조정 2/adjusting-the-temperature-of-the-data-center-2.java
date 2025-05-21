import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        int g = sc.nextInt();
        int h = sc.nextInt();
        int[] ta = new int[n];
        int[] tb = new int[n];

        for (int i = 0; i < n; i++) {
            ta[i] = sc.nextInt();
            tb[i] = sc.nextInt();
        }
        // Please write your code here.

        int maxWorkSum = 0;
        for (int i = -1; i <= 1001; i++) {
            int sum = 0 ;
            for (int j = 0; j < n; j++) {
                if (i < ta[j]) {
                    sum += c;
                } else if (i <= tb[j]) {
                    sum += g;
                } else {
                    sum += h;
                }
            }
            maxWorkSum = Math.max(maxWorkSum, sum);
        }

        System.out.print(maxWorkSum);
    }
}


// 최고 작업량을 산출해야 함.