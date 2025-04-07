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

        Arrays.sort(matrix, (a, b) -> a[0] - b[0]); // 시작 시간 기준 정렬

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(matrix[0][1]); // 첫 회의 끝나는 시간 넣기

        for (int i = 1; i < N; i++) {
            if (pq.peek() <= matrix[i][0]) {
                pq.poll(); // 겹치지 않으니 기존 회의실 사용
            }
            pq.add(matrix[i][1]); // 새 회의 종료 시간 넣기
        }

        System.out.println(pq.size()); // 필요한 회의실 수
    }
}
