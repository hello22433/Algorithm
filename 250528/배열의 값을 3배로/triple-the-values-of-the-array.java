import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.

        Scanner sc = new Scanner(System.in);


        for (int i = 0; i < 3; i++) {
            
            for (int j  = 0; j < 3; j++) {
                System.out.print(sc.nextInt() * 3 + " ");
            }
            System.out.println();
        }
    }
}