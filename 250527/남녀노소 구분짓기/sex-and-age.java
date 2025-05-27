import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        
        if (a == 0) {
            if (b>=19) {
                System.out.print("MAN");
            } else {
                System.out.print("BOY");
            }
        } else {
            if (b>=19) {
                System.out.print("WOMAN");
            } else {
                System.out.print("GIRL");
            }
        }
    }
}