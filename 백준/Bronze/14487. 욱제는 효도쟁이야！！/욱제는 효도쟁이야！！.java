import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int N = sc.nextInt();
        
        for (int i = 0; i < N; i++) {
            pq.add(sc.nextInt());
        }

        int result= 0;
        while (pq.size() != 1) {
            result += pq.poll();
        }
        System.out.print(result);
    }
}