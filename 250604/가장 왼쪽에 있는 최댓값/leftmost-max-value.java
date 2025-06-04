import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            arr[i] = num;
        }

        
        boolean[] check = new boolean[n];

        while (true) {
            
            int maxI = -1;
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < n; i++) {

                if (check[i]) break;

                // 최대값의 위치 갱신
                if (arr[i] > max) {
                    max = Math.max(max, arr[i]);
                    maxI = i;
                }
                
                
            }
            check[maxI] = true;
            if (check[0]) break;
        }
        
        for (int i = n-1; i >= 0; i--) {
            if (check[i]) {
                System.out.print(i + 1 + " ");
            }
        }

    }
}
