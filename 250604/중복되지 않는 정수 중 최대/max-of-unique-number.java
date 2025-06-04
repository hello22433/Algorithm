import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        boolean[] check = new boolean[1001];

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if (!check[num]) {
                check[num] = true;
                max = Math.max(max, num);
            }
        }
        System.out.print(max);

    }
}
