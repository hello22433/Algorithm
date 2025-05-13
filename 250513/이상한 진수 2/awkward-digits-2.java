import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        // Please write your code here.
        StringBuilder sb = new StringBuilder();
        boolean changed = false;
        for (int i = 0; i < a.length(); i++) {
            if (!changed && a.charAt(i)=='0') {
                changed = true;
                sb.append("1");
            } else if (i == a.length()-1 && !changed) {
                sb.append("0");
            } else {
                sb.append(String.valueOf(a.charAt(i)));
            }
        }
        String resultStr = sb.toString();

        int num = 0;
        for (int i = 0; i < resultStr.length(); i++) {
            num = num * 2 + Character.getNumericValue(resultStr.charAt(i));
        }

        System.out.print(num);
    }
}

// a에서 숫자를 하나씩 바꿔서 10진법으로 나타낸다.
// 