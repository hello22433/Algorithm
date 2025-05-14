import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        // Please write your code here.

        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= n - k; i++) {
            int bucket = 0;
            for (int j = i; j < i+k; j++) {
                bucket += arr[j];
            }
            max = Math.max(max, bucket);
        }
        System.out.print(max);
    }
}

// 