import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String A = sc.next();

        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == 'e') {
                System.out.print(A.substring(0,i) + A.substring(i+1));
                break;
            }
        }
    }
}