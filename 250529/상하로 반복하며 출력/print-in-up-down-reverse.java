import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] arr1= new int[n][n];
        for (int i = 0 ; i < n; i++) {
            
            int num = 1;
            if (i%2==0) {
                for (int j  = 0 ; j < n; j++) {
                    arr1[j][i] = num++;
                }
            } else {
                for (int j  = n-1 ; j >= 0; j--) {
                    arr1[j][i] = num++;
                }
            }
            
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n ; j++) {
                System.out.print(arr1[i][j]);
            }
                System.out.println();
        }


    }
}