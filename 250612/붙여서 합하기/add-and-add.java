import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String A = sc.next();
        String B = sc.next();

        System.out.print(Integer.parseInt(A+B) + Integer.parseInt(B+A));
    }
}

