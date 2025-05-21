import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        // Please write your code here.

        int cnt = 0;
        for (int i = x; i <= y; i++) {
            String strI = String.valueOf(i);

            boolean check = false;
            for (int j = 0; j < strI.length()/2 +1; j++) {
                int frontChar = strI.charAt(j);
                int backChar = strI.charAt(strI.length() - 1 - j);

                if (frontChar != backChar) {
                    check = true;
                    break;
                }
            }
            if (!check) {
                cnt++;
            }
        }
        System.out.print(cnt);
    }
}

// 