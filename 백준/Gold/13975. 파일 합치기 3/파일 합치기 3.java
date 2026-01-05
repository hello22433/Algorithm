import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();


        for (int i = 0; i < t; i++) {
            long costSum = 0;

            int n = sc.nextInt();
            PriorityQueue<Long> pq = new PriorityQueue<>();
            for (int j = 0; j < n; j++) {
                pq.add((long) sc.nextInt());
            }

            while (pq.size() > 1) {
                long curVal = pq.poll();
                long nextVal = pq.poll();
                long sumVal = curVal + nextVal;
                costSum += sumVal;
                pq.add(sumVal);
            }

            System.out.println(costSum);
        }
    }
}