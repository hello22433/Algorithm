import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String S = sc.next();

        while (true) {
            int delIdx = sc.nextInt();

            if (delIdx > S.length()-1) {
                S = S.substring(0,S.length()-1);
            } else {
                S = S.substring(0,delIdx) + S.substring(delIdx+1);
            }
                
            System.out.println(S);

            if (S.length() == 1) break;
        }
        
    }
}