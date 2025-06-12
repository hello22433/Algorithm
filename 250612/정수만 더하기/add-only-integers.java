import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String A = sc.next();

        int sum = 0;
        for (int i = 0; i < A.length(); i++) {
            char xChar = A.charAt(i);
            if ('0' <= xChar && xChar <= '9') {
                sum += Character.getNumericValue(xChar);
            }
        }
        System.out.print(sum);
    }
}

