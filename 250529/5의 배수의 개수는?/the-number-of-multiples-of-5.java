import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.

        Scanner sc = new Scanner(System.in);


        int[][] arr1= new int[4][4];
        int cnt = 0;
        for (int i = 0; i <= 3; i++) {
            int sum = 0;
            for (int j  = 0; j <= 3; j++) {
                if (sc.nextInt() % 5 == 0) {
                    cnt++;
                }
            }
        }

        System.out.print(cnt);

    }
}