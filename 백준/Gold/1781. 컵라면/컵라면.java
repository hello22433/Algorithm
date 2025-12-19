
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        ArrayList<int[]> list = new ArrayList<>();



        for (int i = 0; i < n; i++) {
            int deadLine = scanner.nextInt();
            int point = scanner.nextInt();
            list.add(new int[]{deadLine, point});
        }

        Collections.sort(list, (a,b) -> {
//            if (a[0] == b[0]) {
//                return b[1] - a[1];
//            }
            return a[0] - b[0];
        });

        long result = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();



        for (int i = 0; i < n; i++) {
            pq.add(list.get(i)[1]);

            if (pq.size() > list.get(i)[0]) {
                pq.poll();
            }
        }

        while (!pq.isEmpty()) {
            result += pq.poll();
        }

        System.out.println(result);


        // 데드라인 오름차순 정렬 -> 만약 내림차순으로 정렬한다면(기한이 가장 넉넉한 걸 먼저 고려한다면)
        //
        // 데드라인 내에서 최대로 많이 고르되, 가장 점수가 낮은걸 쳐내야 한다.
        //
    }

}
