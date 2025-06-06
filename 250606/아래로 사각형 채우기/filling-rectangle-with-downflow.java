import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] arr1 = new int[n][n];

        int num = 1;
        // 열
        for (int i = 0; i < n; i++) {
            // 행
            for (int j = 0; j < n; j++) {
                arr1[j][i] = num++;
            }
        }

        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr1[i][j] + " ");
            }
            System.out.println();
        }
    }
}