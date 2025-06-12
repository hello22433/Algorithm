import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String strN = Integer.toString(n);

        int sum = 0;
        for (int i = 0; i < strN.length(); i++) {
            sum += Character.getNumericValue(strN.charAt(i));
        }
        System.out.print(sum);
    }
}

