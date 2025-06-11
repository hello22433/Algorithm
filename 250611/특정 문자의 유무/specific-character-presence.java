import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String A = sc.next();
        String ee = "ee";
        String ab = "ab";
        boolean eeExist = false;
        boolean abExist = false;
        
        // ee
        for (int i = 0; i < A.length() - 2; i++) {
            boolean allSame = true;
            for (int j = 0; j < 2; j++) {
                if (A.charAt(i+j) != ee.charAt(j)) {
                    allSame = false;
                }
            }

            if (allSame) {
                eeExist = true;
            }
        }


        // ab
        for (int i = 0; i < A.length() - 2; i++) {
            boolean allSame = true;
            for (int j = 0; j < 2; j++) {
                if (A.charAt(i+j) != ab.charAt(j)) {
                    allSame = false;
                }
            }

            if (allSame) {
                abExist = true;
            }
        }

        if (eeExist) {
            System.out.print("Yes ");
        } else {
            System.out.print("No ");
        }

        if (abExist) {
            System.out.print("Yes");
        } else {
            System.out.print("No");
        }
    }
}