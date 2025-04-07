

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 0;
        
        while (N >= 0) {
            if (N % 5 == 0) {
                count += N / 5;
                System.out.println(count);
                return;
            }
            N -= 2;
            count++;
        }
        
        System.out.println(-1);
    }
}

// 배수가 아니고 남은 돈을 커버할 수 있지 않다. (1이 없음)
// 2로 5와 나누어야 한다.
// 5로 빼고, 2의 배수면 2로 모두 뺀다.?
// 2의 배수와 5의 배수에서 공통은 10의 배수이다.
// 즉, 10의 배수일 때는 둘의 조건이 겹친다는 의미이다.
// 즉, 10의 배수일때는 5원을 뺴는게 맞다. 왜냐하면 최소 동전을 구해야하기 때문.
// 즉 5의 배수일때는 무조건 5를 뺀다. else if 2의 배수일떄는 2를 뺀다.

// else 일때는 2의 배수가 될 떄까지 5로 뺀다
// 반대로 5의 배수가 될 때까지 2로 뺄 수도 있다.
// 아니면 7로 뺄 수도 있다.
// 즉 2, 5, 7로 빼는 경우의 수가 생긴다.
// 2의배수 5의배수 7의배수
// 