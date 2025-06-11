import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            sb.append(str);

        }

        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < sb.length(); i++) {
            sb2.append(String.valueOf(sb.charAt(i)));
            if (sb2.length() == 5) {
                System.out.println(sb2.toString());
                sb2 = new StringBuilder();
            }
        }

        if (sb2.length() != 5) {
            System.out.print(sb2.toString());
        }
    }
}