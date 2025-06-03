import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;
        int[] arr = new int[105];

        for (int i = 0; i < 105; i++) {
            arr[i] = sc.nextInt();
            if (arr[i] == 0) {
                System.out.print(arr[i-3] + arr[i-2] + arr[i-1]);
                break;
            }
        }
    }
}
