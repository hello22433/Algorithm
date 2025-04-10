

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pq.add(sc.nextLong());
        }

        for (int i = 0; i < M; i++) {
            long poller1 = pq.poll();
            long poller2 = pq.poll();

            pq.add(poller1 + poller2);
            pq.add(poller1 + poller2);
        }

        long sum = 0;
        while (!pq.isEmpty()) {
            sum += pq.poll();
        }
        System.out.println(sum);
    }
}

// 가장 작은 것들을 계쏙해서 더한다.
// 최소힙에 넣고 두번 폴하고 두번 더한 값을 넣는다.
// 이를 M번 반복