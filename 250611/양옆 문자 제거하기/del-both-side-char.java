import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String S = sc.next();

        System.out.print(S.substring(0,1) + S.substring(2,S.length()-2) + S.substring(S.length()-1));
    }
}