import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String A = sc.next();
        String command = sc.next();

        for (int i = 0; i < command.length(); i++) {
            char com = command.charAt(i);

            if (com == 'L') {
                A = A.substring(1) + A.substring(0,1);
            } else if (com == 'R') {
                A = A.substring(A.length()-1) + A.substring(0,A.length()-1);
            }
        }

        System.out.print(A);
    }
}