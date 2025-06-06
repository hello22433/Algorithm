import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 행크기
        int n = sc.nextInt();
        // 열크기
        int m = sc.nextInt();

        int[][] arr1 = new int[n][m];

        int num = 0;
        // 열
        for (int i = 0; i < m; i++) {
            // 행
            if (i % 2 ==0) {
                for (int j = 0; j < n; j++) {
                    arr1[j][i] = num++;
                }
            } else {
                for (int j = n-1; j >= 0; j--) {
                    arr1[j][i] = num++;
                }
            }
            
        }

        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr1[i][j] + " ");
            }
            System.out.println();
        }
    }
}