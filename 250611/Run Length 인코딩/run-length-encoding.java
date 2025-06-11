import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        char ch = str.charAt(0);
        int chCnt = 1;
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < str.length(); i++) {
            if (ch == str.charAt(i)) {
                chCnt++;
            } else {
                sb.append(String.valueOf(ch));
                sb.append(chCnt);
                if (i != str.length()-1) {
                    ch = str.charAt(i);
                    chCnt = 1;
                }
                // 만약 마지막 순회가 아니었다면 다음 것을 단어에 넣고 카운트를 0으로 쳐서 다음에 1로 초기화되게 한다.
            }
        }
        sb.append(String.valueOf(ch));
        sb.append(chCnt);

        System.out.print(sb.length() + "\n" + sb.toString());
    }
}