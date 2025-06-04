import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        boolean[] check = new boolean[1001];
        boolean[] check2 = new boolean[1001];

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            int num = arr[i];

            if (!check[num]) {
                check[num] = true;
            } else {
                check2[num] = true;
            }
        }
        
        int max = -1;
        for (int i = 0; i < n; i++) {
            if (!check2[arr[i]]) {
                max = Math.max(max, arr[i]);
            }
        }
        System.out.print(max);
    }
}
