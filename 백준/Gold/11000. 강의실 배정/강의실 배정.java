

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] matrix = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());
            matrix[i][0] = S;
            matrix[i][1] = T;
        }

        Arrays.sort(matrix, (a,b) -> {
            return a[0] - b[0];
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(matrix[0][1]);

        int answer = 1;
        for (int i = 1; i < N; i++) {
            if (pq.peek() <= matrix[i][0]) {
                pq.poll();
            }
            pq.add(matrix[i][1]);
        }

        System.out.println(pq.size());
    }
}

// 끝나는 시간을 기준으로 오름차순 정렬한다.(더 빨리 끝나는 순)
// 끝나는 시간이 같으면 시작시간이 더 빠른 걸로 정렬한다. 어차피 처리해야 할 것이었기 때문.
//
// 우선순위 큐에 끝나는 시간만 저장한다.
// 만약 peek보다 다음 시작시간이 더 작다면 큐에다가 넣는다.
// 아니라면 poll하고 끝나는 시간을 큐에다가 넣는다.
// 매번 마지막에 큐의 사이즈를 max로 갱신한다.