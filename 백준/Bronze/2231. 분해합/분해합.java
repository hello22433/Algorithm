
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 1; ; i++) {
            int iLength = String.valueOf(i).length();
            int hap = i;
            for (int j = 0; j < iLength; j++) {
                hap += Character.getNumericValue(String.valueOf(i).charAt(j));
            }
            if (hap == N) {
                System.out.println(i);
                return;
            } else if (i > N) {
                System.out.println(0);
                return;
            }
        }
    }
}

// 분해합 : N + N의 각자리수의 합
// 주어진 수 N의 가장 작은 생성자를 구하라.
// 1부터 구한다. vs 무한분해합으로 구한다.
// 무한분해합은 값이 기하급수적으로 커질 뿐더러 작은 수의 보장이 안된다.
// 1부터 계속 분해합을 구하면서 N이 나오면 해당 값을 리턴.
//