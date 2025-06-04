import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // int[][] arr2d = new int[5][3];

        for (int i = 0; i < 5; i++) {
            // int sum = 0;
            for (int j = 0; j < 3; j++) {
                // arr2d[i][j] = sc.nextInt();
                System.out.print(sc.next().toUpperCase() + " ");
                // sum += arr2d[i][j];
            }
            System.out.println();
        }
    }
}