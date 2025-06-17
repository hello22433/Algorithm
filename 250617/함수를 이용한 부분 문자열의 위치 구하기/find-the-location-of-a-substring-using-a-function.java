import java.util.Scanner;
public class Main {
    public static String text;
    public static String pattern;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        text = sc.next();
        pattern = sc.next();

        int Idx = findStartIdx();

        System.out.print(Idx);
    }

    public static int findStartIdx() {
        return text.indexOf(pattern);
    }
}