

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String st = sc.nextLine();
        String[] str = st.split("[+-]");

        int idx = 0;
        boolean numberBool = true;
        boolean plusMinus = true;
        int result = 0;
        int bucket = 0;
        for (int i = 0; i < st.length(); i++) {
            if (st.charAt(i) == '+' || st.charAt(i) == '-') {
                numberBool = true;
                if (plusMinus) {
                    if (st.charAt(i) == '-') {
                        plusMinus = false;
                    }
                } else { // 전 부호가 마이너스 였다면
                    if (st.charAt(i) == '+') {
                        continue;
                    } else {
                        result -= bucket;
                        bucket = 0;
//                        plusMinus = false;
                    }
                }
            } else {
                if (numberBool) {
                    if (plusMinus) {
                        result += Integer.parseInt(str[idx]);
                    } else {
                        bucket += Integer.parseInt(str[idx]);
                    }
                    numberBool = false;
                    idx++;
                }
            }
        }
        result -= bucket;
        System.out.print(result);
    }
}

// -와 +로 스플릿한다.
// 처음 숫자를 결과값에 더한다. Integer.valueOf()

// 탐색한다.
// +거나 -면
// plusMinus(초기값은 트루)가 트루이면 다음 코드로 넘어가고
// 아니라면 +일때는 bucket에 다음 수를 더해야 한다. continue한다. -일때는 bucket을 결과값에 더한다. 그리고 plusMinus를 트루로 바꾼다.
// +일때는 plusMinus를 트루로만든다.
// 아니면 폴스로 만든다.
// 숫자일때는
// plusMinus가 트루이면 결과값에 더한다.
// 아니라면(마이너스였다면) bucket에 숫자를 더한다.
// 숫자이거나
