import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String S = sc.next();
        char[] sArr = S.toCharArray();
        char first = sArr[0];
        char second = sArr[1];

        for (int i = 0; i < sArr.length; i++) {
            if (sArr[i] == second) {
                sArr[i] = first;
            }
        }
        System.out.print(String.valueOf(sArr));
    }
}