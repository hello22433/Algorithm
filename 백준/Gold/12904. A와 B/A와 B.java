
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        String T = sc.nextLine();

        StringBuilder result = new StringBuilder(T);
        for (int i = T.length()-1; i >= 0; i--) {
            if (i == S.length() - 1) {
                break;
            }

            if (result.charAt(i) == 'A') {
                result = new StringBuilder(result.substring(0, i));
            } else {
                result = new StringBuilder(result.substring(0, i));
                result.reverse();
            }
        }

        if (result.toString().equals(S)) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }
}

// 한번의 연산에서 무조건 하나가 추가된다.
// 개수로? A가 2번 B가 1번
// 뒤집기가 1번.
// 거꾸로 한다면?
// A를 빼거나, B를 빼고 뒤집어야 함.
//

