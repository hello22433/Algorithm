
import java.util.*;

public class Main {
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 목표 채널
        int M = sc.nextInt(); // 고장난 버튼 수

        Set<Integer> brokenButtons = new HashSet<>();
        for (int i = 0; i < M; i++) {
            brokenButtons.add(sc.nextInt());
        }

        // 방법 1: + 또는 -만 사용
        min = Math.abs(100 - N);

        // 방법 2: 숫자 버튼으로 만들 수 있는 채널을 전수조사
        for (int i = 0; i <= 1000000; i++) {
            String str = Integer.toString(i);
            boolean isValid = true;

            for (int j = 0; j < str.length(); j++) {
                int digit = str.charAt(j) - '0';
                if (brokenButtons.contains(digit)) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                int pressCount = str.length() + Math.abs(i - N); // 숫자 입력 + +/- 이동
                min = Math.min(min, pressCount);
            }
        }

        System.out.println(min);
    }
}
