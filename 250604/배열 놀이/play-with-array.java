import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         

        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        outer : for (int i = 0; i < q; i++) {
            int command = sc.nextInt();

            if (command == 1) {
                int a = sc.nextInt();
                System.out.println(arr[a-1]);
            } else if (command == 2) {
                int b = sc.nextInt();
                for (int j = 0; j < n; j++) {
                    if (arr[j] == b) {
                        System.out.println(j+1);
                        continue outer;
                    }
                }
                System.out.println(0);
            } else if (command == 3) {
                int s = sc.nextInt();
                int e = sc.nextInt();
                for (int j = s-1; j <= e-1; j++) {
                    System.out.print(arr[j] + " ");
                }
                System.out.println();
            }
        }
    }
}
