
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Long> pq = new PriorityQueue<>((a,b) -> Long.compare(a,b));

        for (int i = 0; i < N; i++) {
            pq.add(sc.nextLong());
        }

        if (pq.size() == 1) {
            System.out.print("0");
            return;
        }
        Long first = pq.poll();
        Long second = pq.poll();
        Long firstSecond = first + second;
        pq.add(firstSecond);
        Long result = firstSecond;
        while (!pq.isEmpty()) {
            Long pollerPlus = pq.poll() + pq.poll();
            result += pollerPlus;
            pq.add(pollerPlus);
            if (pq.size() == 1) {
                break;
            }
        }
        System.out.print(result);

    }
}

// 큰거를 먼저 합치면 누적합이 커져서 비효율적이게 된다.
// 작은 것들을 먼저 합쳐야 한다.
// 배열에 넣고 오름차순으로 정렬한다.
// 누적합을 만들어 순서대로 더해나간다.
// (첫값 + 둘째값) + (누적값 + 폴값) + (누적값 + 폴값)
// 0 10 +  10 20 + 30 40
// 누적합으로 만들어버리면 덜효율적일 수밖에 없음
// 그럼 가장 작은 것들로 만들어서 더해야 한다는 말인데...
// 두묶음씩 더하고 그 결과값을 또 두묶음씩 더하고 하는 식...
// list에 돌면서 2개씩 더해 새로운 List에 넣는다.
// 다돌면 다시 돌면서 새로운 list에 넣는다.
// 만약 1개만 남으면 그만 돌고 그 값을 출력한다.
//