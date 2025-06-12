import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String A = sc.next();

        System.out.print(A.substring(1,A.length()) + A.substring(0,1));
    }
}