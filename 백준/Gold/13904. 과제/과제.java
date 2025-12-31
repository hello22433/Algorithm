import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[][] dw = new int[N][2];

        for (int i = 0; i < N; i++) {
            int d = sc.nextInt();
            int w = sc.nextInt();

            dw[i][0] = d;
            dw[i][1] = w;
        }

        Arrays.sort(dw, (a,b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            pq.add(dw[i][1]);

            while (pq.size() > dw[i][0]) {
                pq.poll();
            }
        }

        int result = 0;
        while (!pq.isEmpty()) {
            result += pq.poll();
        }

        System.out.println(result);


    }





}

// 마감일이 적게 남은 것부터 고려 해야 한다.
// 오름차순 우선순위 큐에 점수를 넣는다.
// 만약 마감일을 지난 걸 골랐다면, 우선순위 큐의 가장 작은 값과 비교하고,
// 고른 게 더 크다면 우선순위 큐에서 가장 작은 값을 빼고 해당 값을 넣는다.