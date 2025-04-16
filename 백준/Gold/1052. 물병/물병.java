
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int count = 0;
        while (Integer.bitCount(N) > K) {
            N++;
            count++;
        }
        System.out.println(count);
    }
}

// 2^n 꼴로 물병이 생성된다.
// 즉 해당값을 이진수로 변경하면 1의 개수가 가장 적은 병의 개수를 의미한다.
// 왜냐하면 해당값의 이진수는 2의 제곱의 합으로 이루어져 있기 때문이다.
// 즉, 2의 제곱 단위 용량의 병들의 합을 의미한다
// Integer.bitCount(N)은 N의 1의 개수 즉, 최소 병의 개수를 의미한다.
// 이 병의 개수가 K보다 작거나 같아야 한다. (이 중에 가장 큰 값이어야 한다.)
// 그럼 N에다가 1씩 더해야 한다. 그럼 총 병의 개수는 하나씩 늘어나면서
// 최소 압축 병 개수를 계산하게 된다.
//
