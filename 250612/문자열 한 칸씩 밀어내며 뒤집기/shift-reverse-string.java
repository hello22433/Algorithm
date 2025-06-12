import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String A = sc.next();
        int Q = sc.nextInt();

        for (int i = 0; i < Q; i++) {
            int num = sc.nextInt();
            if (num == 1) {
                A = A.substring(1) + A.substring(0,1);
            } else if (num == 2) {
                A = A.substring(A.length()-1) + A.substring(0,A.length()-1);
            } else if (num == 3) {
                StringBuilder sb = new StringBuilder();
                for (int j = A.length()-1; j >= 0; j--) {
                    sb.append(String.valueOf(A.charAt(j)));
                }
                A = sb.toString();
            }
            System.out.println(A);
        }
    }
}