import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String A = sc.next();
        String B = sc.next();

        for (int i = 0; i < A.length() - (B.length() - 1); i++) {

            boolean allSame = true;
            for (int j = 0; j < B.length(); j++) {
                if (A.charAt(i+j) != B.charAt(j)) {
                    allSame = false;
                }
            }
            if (allSame) {
                A = A.substring(0,i) + A.substring(i+B.length());
                i = -1;
            }
        }

        System.out.print(A);
    }
}