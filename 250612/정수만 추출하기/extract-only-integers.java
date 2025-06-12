import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String A = sc.next();
        String B = sc.next();

        int sum = 0;
        boolean AAllInt = true;
        for (int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            if (!('0' <= ch && ch <= '9')) {
                AAllInt = false;
                sum += Integer.parseInt(A.substring(0,i));
            }
        }
        if (AAllInt) sum += Integer.parseInt(A);

        boolean BAllInt = true;
        for (int i = 0; i < B.length(); i++) {
            char ch = B.charAt(i);
            if (!('0' <= ch && ch <= '9')) {
                BAllInt = false;
                sum += Integer.parseInt(B.substring(0,i));
            }
        }
        if (BAllInt) sum += Integer.parseInt(B);

        System.out.print(sum);
    }
}

