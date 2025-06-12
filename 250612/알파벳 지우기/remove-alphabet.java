import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String A = sc.next();
        String B = sc.next();
        
        StringBuilder aStr = new StringBuilder();
        for (int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            if ('0' <= ch && ch <= '9') {
                aStr.append(String.valueOf(ch));
            }
        }

        StringBuilder bStr = new StringBuilder();
        for (int i = 0; i < B.length(); i++) {
            char ch = B.charAt(i);
            if ('0' <= ch && ch <= '9') {
                bStr.append(String.valueOf(ch));
            }
        }

        System.out.print(Integer.parseInt(aStr.toString()) + Integer.parseInt(bStr.toString()));
    }
}

