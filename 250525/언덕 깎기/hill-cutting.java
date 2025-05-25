import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // Please write your code here.


        int minCost = Integer.MAX_VALUE;
        for (int h = 0; h <= 100; h++) {
            
            int cost = 0;
            for (int i = 0; i < n; i++) {
                int arrI = arr[i];
                int arrICost = 0;
                // 최저점보다 17 더 떨어져 있으면 점을 하나씩 내려야 한다.
                while (arrI - h > 17) {
                    arrI--;
                    arrICost++;
                }
                // 최저점보다 낮으면 최저점까지 맞춰줘야 한다.
                while (h > arrI) {
                    arrI++;
                    arrICost++;
                }
                cost += arrICost * arrICost;
            }
            minCost = Math.min(minCost, cost);
        }
        System.out.print(minCost);
    }
}

// 