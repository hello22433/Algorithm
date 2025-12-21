
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        ArrayList<int[]> pot = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int p = scanner.nextInt();
            int d = scanner.nextInt();

            pot.add(new int[]{p, d});
        }

        pot.sort((a, b) -> a[1] - b[1]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            pq.offer(pot.get(i)[0]);

            if (pq.size() > pot.get(i)[1]) {
                pq.poll();
            }
        }

        int result = 0;
        while (!pq.isEmpty()) {
            int poller = pq.poll();
//            System.out.println(poller);
            result += poller;
        }

        System.out.println(result);

    }

}


// 데드라인으로 오름차순 정렬을 한다.
// 일자를 늘려가면서 점수를 체크한다.
// 만약 점수를 계속 넣다가 데드라인보다 현재 일자가 더 높으면 그냥 넘어간다.
// 만약 점수를 넣었는데 점수들이 데드라인보다 더 많으면, 가장 낮은 점수를 뺀다.

// 1일차에 데드라인 1일차 중에서 가장 최선의 선택을 한다.
// 2일차에 데드라인 2일차 중에서 가장 최선의 선택을 한다. 만약 이번에 고른 것의 데드라인이 1일차라면
// (1일 차가 여러개)