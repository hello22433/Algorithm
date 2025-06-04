import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] arr2d = new int[2][4];

        // 가로평균
        for (int i = 0; i < 2; i++) {
            int sum = 0;
            for (int j = 0; j < 4; j++) {
                arr2d[i][j] = sc.nextInt();
                sum += arr2d[i][j];
            }
            System.out.printf("%.1f ", sum/(double)4);
        }
        System.out.println();

        
        // 세로평균
        for (int i = 0; i < 4; i++) {
            int sum = 0;
            for (int j = 0; j < 2; j++) {
                sum += arr2d[j][i];
            }
            System.out.printf("%.1f ", sum/(double)2);
        }
        System.out.println();
        
        // 전체평균
        int sum = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                sum += arr2d[i][j];
            }
        }
        System.out.printf("%.1f ", sum/(double)8);

    }
}