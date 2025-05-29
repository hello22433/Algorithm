import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] arr1= new int[4][4];
        for (int i = 0; i < n; i++) {
            if (i%2==0) {
                int num = 1;
                for (int j  = 0; j < n; j++) {
                    System.out.print(num++);
                }
            } else {
                int num = n;
                for (int j  = 0; j < n; j++) {
                    System.out.print(num--);
                }
            }
            System.out.println();
        }


    }
}