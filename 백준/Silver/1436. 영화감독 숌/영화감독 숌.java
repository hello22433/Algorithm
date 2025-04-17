
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int count = 0;
        for (int i = 1; ; i++) {
            String iStr = String.valueOf(i);
            int sixCount = 0;
            for (int j = 0; j < iStr.length(); j++) {
                if (iStr.charAt(j) != '6' && sixCount > 0) {
                    sixCount = 0;
                } else if (iStr.charAt(j) == '6') {
                    ++sixCount;
                }

                if (sixCount == 3) {
                    ++count;
                    break;
                }
            }
            if (count == N) {
                System.out.println(i);
                return;
            }
        }

    }
}

// 1부터 하나씩 올라가면서 666을 포함하고 있는지 확인한다.
// 포함하고 있다면 카운트를 올린다.
// 카운트가 N과 일치하면 i를 출력하고 리턴한다.