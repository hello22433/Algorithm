import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.

        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();

        while (A!=25) {
            if (A>25) {
            System.out.println("Lower");

            } else {
            System.out.println("Higher");

            }
            A = sc.nextInt();
        }
        System.out.print("Good");
    }
}