import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();  
        
        for (int sc : scoville) {
            pq.offer(sc);
        }
        
        while (pq.size() >= 2 && pq.peek() < K) {
            answer++;
            int first = pq.poll();
            int second = pq.poll();
            
            int mixedScoville = first + second * 2;
            pq.offer(mixedScoville);
        }
        
        if (pq.peek() < K) return -1;
        
        return answer;
    }
}