import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (isMagicNum(n)) {
            System.out.print("Yes");
        } else {
            System.out.print("No");
        }
    }

    public static boolean isMagicNum(int n) {
        if (n % 2 == 0) {
            String nStr = Integer.toString(n);
            int sum = 0 ;
            for (int i = 0; i < nStr.length(); i++) {
                sum += Character.getNumericValue(nStr.charAt(i));
            }
            if (sum % 5 == 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    } 
}