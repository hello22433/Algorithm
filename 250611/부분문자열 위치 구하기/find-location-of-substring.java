import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String inputStr = sc.next();
        String str = sc.next();

        for (int i = 0; i < inputStr.length()-(str.length()-1); i++) {
            
            boolean allSame = true;
            for (int j = 0; j < str.length(); j++) {
                if (inputStr.charAt(i+j) != str.charAt(j)) {
                    allSame = false;
                }
            }

            if (allSame) {
                System.out.print(i);
                return;
            }
        }

        System.out.print(-1);
    }
}