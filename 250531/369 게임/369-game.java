import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            String strI = String.valueOf(i);
            
            if (Character.getNumericValue(strI.charAt(0))%3 == 0) {
                System.out.print(0 + " ");
            } else {
                if (strI.length() > 1 && Character.getNumericValue(strI.charAt(1)) != 0 && Character.getNumericValue(strI.charAt(1))%3 == 0) {
                    System.out.print(0 + " ");
                } else {
                    System.out.print(i + " ");
                }
                
            }
        }

    }
}
