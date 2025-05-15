import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        // Please write your code here.

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                double avg = 0;
                for (int k = i; k <= j; k++) {
                    avg += arr[k];
                }
                avg = avg / (double) (j-i+1);

                for (int k = i; k <= j; k++) {
                    if ((double) arr[k] == avg) {
                        count++;
                        break;
                    }
                }
            }
        }
        System.out.print(count);
    }
}

// 