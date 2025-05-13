import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        // Please write your code here.
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < n-2; i++) {
            int bucketSum = arr[i];
            for (int j = i+2; j < n; j++) {
                bucketSum += arr[j];
                maxSum = Math.max(maxSum, bucketSum);
                bucketSum -= arr[j];
            }
        }

        System.out.print(maxSum);
    }
}

