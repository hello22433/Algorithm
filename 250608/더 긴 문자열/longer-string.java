import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str1 = sc.next();
        String str2 = sc.next();
        int len = Math.max(str1.length(), str2.length());

        if (str1.length() == str2.length()) {
            System.out.print("same");
        } else {
            if (str1.length() > str2.length()) {
                System.out.print(str1 + " " + len);
            } else {
                System.out.print(str2 + " " + len);
            }
        }
    }
}
