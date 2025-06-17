import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        // Please write your code here.
        
        if (twoDiffABC(A)) {
            System.out.print("Yes");
        } else {
            System.out.print("No");
        }
    }

    public static boolean twoDiffABC(String s) {
        char firstCh = s.charAt(0);

        for (int i = 1; i < s.length(); i++) {
            if (firstCh != s.charAt(i)) return true;
        }

        return false;
    }
}