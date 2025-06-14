import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();

        int cnt = 0;
        for (int i = A; i <= B; i++) {
            if (isMagicNum(i)) {
                cnt++;
            }
        }
        System.out.print(cnt);
    }

    public static boolean isMagicNum(int num) {
        if (haveThreeOrSixOrNine(num) || num % 3 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean haveThreeOrSixOrNine(int num) {
        String numStr = Integer.toString(num);
        for (int i = 0; i < numStr.length(); i++) {
            if (numStr.charAt(i) == '3' || numStr.charAt(i) == '6' || numStr.charAt(i) == '9') {
                return true;
            }
        }
        return false;
    }
}

// A -> B
// 369 중 하나가 들어가 있는지? OR
// 그 수 자체가 3의 배수인지?