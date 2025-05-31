import java.util.Scanner;
import java.math.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        double result = a / (double) b;
        BigDecimal val = new BigDecimal(a).divide(new BigDecimal(b), 20, RoundingMode.DOWN);
        String resultStr = String.valueOf(val);

        String str = "";
        
        boolean checkPoint = false;
        int cnt = 0;

        for (int i = 0; ; i++) {
            if (i >= resultStr.length()) {
                str += "0";
            } else {
                str += resultStr.charAt(i);
                if (resultStr.charAt(i) == '.') {
                    checkPoint = true;
                }
            }

            

            if (checkPoint) {
                cnt++;
                if (cnt == 21) {
                    System.out.print(str);
                    return;
                }
            } 

        }
    }
}
