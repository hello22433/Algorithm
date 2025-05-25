import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int minCost = Integer.MAX_VALUE;
        for (int i = 1; i <= 10000; i++) {
            
            int cost = 0;
            for (int j = 0; j < n; j++) {
                int arrI = arr[j];

                while (arrI - k > i) {
                    arrI--;
                    cost++;
                }

                while (arrI < i) {
                    arrI++;
                    cost++;
                }

            }
            minCost = Math.min(minCost, cost);
        }

        System.out.print(minCost);
    }
}


// N개의 수의 최소값을 지정한다.
// 최소값보다 크다면 K이내가 될때까지 1씩 뺀다. 뺄때마다 비용을 추가한다.
// 작다면 최소값이 될 떄까지 1씩 더한다. 더할때마다 비용을 추가한다.
//