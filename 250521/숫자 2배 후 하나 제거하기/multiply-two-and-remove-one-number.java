import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // Please write your code here.

        int minDiffSum = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] *= 2;

            // 하나를 골라서 제외한다.
            for (int j = 0; j < n; j++) {
                int[] newArr= new int[n-1];
                int newArrIdx = 0;
                for (int k = 0; k < n; k++) {
                    if (j==k) continue;
                    newArr[newArrIdx++] = arr[k];
                }

                int diffSum = 0;
                for (int k = 0; k < n-1-1; k++) {
                    diffSum += Math.abs(newArr[k+1]-newArr[k]);
                }
                minDiffSum = Math.min(minDiffSum, diffSum);
            }

            arr[i] /= 2;
        }

        System.out.print(minDiffSum);
    }
}

// 