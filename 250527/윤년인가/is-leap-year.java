import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        
        if (a % 4 ==0 || (a % 100==0 && a % 400 != 0)) {
            System.out.print("true");
        } else {
            System.out.print("false");
        }
    }
}