import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String a = sc.next();
        String b = sc.next();

        int sameCnt = 0;
        for (int i = 0; i < a.length()-(b.length()-1); i++) {
            
            boolean allSame = true;
            for (int j = 0; j < b.length(); j++) {
                if (a.charAt(i+j) != b.charAt(j)) {
                    allSame = false;
                }
            }

            if (allSame) {
                sameCnt++;
            }
        }

        System.out.print(sameCnt);
    }
}