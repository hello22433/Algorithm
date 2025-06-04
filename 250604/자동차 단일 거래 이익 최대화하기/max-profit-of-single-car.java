import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        int maxProfit = 0;
        for (int i = 0; i < n ; i++) {
            for (int j = i+1; j < n; j++) {
                maxProfit = Math.max(maxProfit, arr[j] - arr[i]);
            }
        }
        System.out.print(maxProfit);
    }
}


// 가장 작은 수로 사 놓고 이후 가장 큰 수로 사야 한다.
// 다만 가장 작지 않더라도 그 뒤의 수가 아주 크다면 이익이 생길 수 있다.
// 즉, 가장 작은 수를 하나씩 지정하고 