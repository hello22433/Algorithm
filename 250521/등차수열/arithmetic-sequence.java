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

        int maxCount = Integer.MIN_VALUE;
        for (int i = 1; i <= 100; i++) {
            
            int count = 0;
            for (int j = 0; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    if (arr[j] - i == i - arr[k]) {
                        count++;
                    }
                }
            }

            maxCount = Math.max(count, maxCount);
        }
        System.out.print(maxCount);
    }
}

// 