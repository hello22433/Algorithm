
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (N % i == 0) {
                ++count;
            }
            if (count == K) {
                System.out.println(i);
                return;
            }
        }

        System.out.println(0);

    }
}



// N을 1부터 나누며 약수를 구한다.
// i만약 나누어지면 count에 1을 더한다.
// 만약 count가 K가 되면 i를 출력한다.
// 만약 count가 K보다 작다면 0을 출력한다.