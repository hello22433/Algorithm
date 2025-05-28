import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.

        Scanner sc = new Scanner(System.in);

        int[][] arr1= new int[3][3];
        for (int i = 0; i <= 2; i++) {
            
            for (int j  = 0; j <= 2; j++) {
                arr1[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i <= 2; i++) {
            
            for (int j  = 0; j <= 2; j++) {
                System.out.print(sc.nextInt() * arr1[i][j] + " ");
            }
            System.out.println();
        }
    }
}