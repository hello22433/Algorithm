import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] arr1= new int[N][M];
        for (int i = 0; i <= N-1; i++) {
            
            for (int j  = 0; j <= M-1; j++) {
                arr1[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i <= N-1; i++) {
            
            for (int j  = 0; j <= M-1; j++) {
                if (sc.nextInt() == arr1[i][j]) {
                    System.out.print(0 + " ");
                } else {
                    System.out.print(1 + " ");
                }
            }
            System.out.println();
        }
    }
}