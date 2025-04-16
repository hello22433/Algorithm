
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        boolean[] visited = new boolean[N+1];
        int[] expect = new int[N];
        for (int i = 0; i < N; i++) {
            expect[i] = sc.nextInt();
        }
        Arrays.sort(expect);

        long count = 0;
        for (int i = 0; i < N; i++){
            int num = expect[i];
            count += Math.abs(i+1 - num);
        }
        System.out.println(count);
    }
}

// 예상등수대로 그대로 넣는다.
// 만약 그 자리에 이미 들어가 있다면 다음 등수에 넣는다.
// 오름차순으로 입력값을 정리한다.
// pointer을 옮겨가며 visited를 체크하며 체크한다.
// 만약 visited가 false라면 pointer+=1하고
// true라면 visited가 false인 값을 찾을 때까지 pointer+=1하며
// count +=1 한다.
//
//