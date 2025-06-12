import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String A = sc.next();
        int L = A.length();
        System.out.println(A);

        for (int i = 0; i < L; i++) {
            A = A.substring(A.length()-1,A.length()) + A.substring(0,A.length()-1);
            System.out.println(A);
        }
    }
}