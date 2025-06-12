import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String x = sc.next();

        for (int i = 0; i < x.length(); i++) {
            char xChar = x.charAt(i);
            if ('a' <= xChar && xChar <= 'z') {
                System.out.print((char)(xChar - 'a' + 'A'));
            } else if ('A' <= xChar && xChar <= 'Z') {
                System.out.print((char)(xChar - 'A' + 'a'));
            }
        }
    }
}

