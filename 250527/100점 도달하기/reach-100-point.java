import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc= new Scanner(System.in);

        int a = sc.nextInt();

        for (int s = a; s <= 100; s++) {
            if (s >= 90) {
                System.out.print("A ");
            } else if (s >= 80) {
                System.out.print("B ");
            } else if (s >= 70) {
                System.out.print("C ");
            } else if (s >= 60) {
                System.out.print("D ");
            } else {
                System.out.print("F ");
            }
        }

        
    }
}