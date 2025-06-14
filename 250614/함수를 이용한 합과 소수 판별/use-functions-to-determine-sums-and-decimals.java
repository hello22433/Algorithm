import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        // Please write your code here.

        int cnt = 0;
        for (int i = a; i<=b; i++) {
            if (isPrimeNum(i) && isDigitsSumEvenNum(i)) {
                cnt++;
            }
        }
        System.out.print(cnt);
    }

    public static boolean isPrimeNum(int num) {
        for (int i = 2; i<num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isDigitsSumEvenNum(int num) {
        String numStr = String.valueOf(num);
        int sum = 0;
        for (int i = 0; i<numStr.length(); i++) {
            sum += Character.getNumericValue(numStr.charAt(i));
                
        }
        if (sum % 2 != 0) return false;
        else return true;
    }
}