
import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {
    static int M;
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        int sum = 0;
        int min = Integer.MAX_VALUE;

        for (int i = M; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                if (i / j == j && i % j == 0) {
                    sum += i;
                    min = Math.min(min, i);
                    break;
                }
            }
        }

        if (sum == 0) {
            System.out.print(-1);
        } else {
            System.out.println(sum);
            System.out.print(min);
        }
    }
}

// M~N까지 탐색한다.
// i번째 수마다 1부터 i까지 탐색한다. (j)
// j로 나누었을 때 나머지가 없고 j와 같은 수가 몫으로 나오면 해당 수는 완전제곱수이므로
// count += 1 한다. break;
// 만약 몫이 j보다 커지면 더이상 완전제곱수로 볼 수 없으므로 break;
// countrk 0이면 -1출력

