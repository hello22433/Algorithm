// 가장 비싼것들끼리 3개씩 묶다가
// 남은 것들의 사이즈가 3보다 작으면 멈춘다
// 가장 큰 값을 삭제시켜야 하며, 어떻게던 할인을 큰 값을 받게 하는게 좋기 때문

import java.util.*;

class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            
            pq.add(num);
        }
        
        long sum = 0;
        while (pq.size() >= 3) {
            sum += pq.poll() + pq.poll();
            pq.poll();
            
        }
        
        while (!pq.isEmpty()) {
            sum += pq.poll();
        }
        
        System.out.print(sum);
    }
}