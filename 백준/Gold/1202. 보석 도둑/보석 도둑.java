

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static class Jewel {
        int weight;
        int price;

        Jewel(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Jewel[] jewels = new Jewel[N];
        int[] bags = new int[K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            jewels[i] = new Jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            bags[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(jewels, (a,b) -> {
            if (a.weight == b.weight) {
                return b.price - a.price;
            }
            return a.weight - b.weight;
        });
        Arrays.sort(bags);

        int jewelsIdx = 0;
        long result = 0;
        PriorityQueue<Jewel> pq = new PriorityQueue<>((a,b) -> {
//            if (b.price == a.price) {
//                return b.weight-a.weight;
//            }
            return b.price - a.price;
        });
        for (int i = 0; i < K; i++) {
            while (jewelsIdx < N && bags[i] >= jewels[jewelsIdx].weight) {
                pq.offer(jewels[jewelsIdx]);
                jewelsIdx++;
            }
            if (!pq.isEmpty()) {
                result += pq.poll().price;
            }
        }

        System.out.println(result);
    }
}

//