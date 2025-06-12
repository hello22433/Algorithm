import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String a = sc.next();

        int b = (int) a.charAt(0) - 1;
        if (b < 97) b = 122;

        System.out.print((char) b);
    }
}