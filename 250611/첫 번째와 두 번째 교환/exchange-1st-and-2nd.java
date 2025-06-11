import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String a = sc.next();

        char firstCh = a.charAt(0);
        char secondCh = a.charAt(1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == firstCh) {
                sb.append(String.valueOf(secondCh));
            } else if (a.charAt(i) == secondCh) {
                sb.append(String.valueOf(firstCh));
            } else {
                sb.append(String.valueOf(a.charAt(i)));
            }
        }

        System.out.print(sb.toString());
    }
}