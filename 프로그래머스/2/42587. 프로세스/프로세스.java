import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int count = 1;
                
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> {
            return b-a;
        });
        
        Queue<Integer> q = new ArrayDeque<>();
        
        for (int p : priorities) {
            pq.offer(p);
            q.offer(p);
        }
        
        
        while (!q.isEmpty()) {
            int evaluatedNum = q.poll();
            if (pq.peek() == evaluatedNum) {
                if (location == 0) return count;
                else {
                    pq.poll();
                    count++;
                    location -= 1;
                }
            } else {
                q.offer(evaluatedNum);
                if (location == 0) {
                    location = q.size() - 1;
                } else {
                    location -= 1;
                }
            }
        }
        
        return count;
    }
}

// priorityQueue(최대힙) 에다가 전부 넣는다
// queue에다가 전부 넣는다.
// queue에서 하나를 빼서, priorityQueue의 peek과 같다면, priorityQueue에서 하나 빼고 queue에서도 그냥 빼버린다.
// 아니라면 queue에서 뺀 것을 다시 queue에다가 넣는다.
// queue에서 아예 빼버릴때, 1부터 시작해서 ++을 한다. 만약 location에 있는 값이 나갈때는 현재 count 값이 나가는 값이다.
// 큐에 넣을때 해당 값이 location의 값인지를 인지를 해야한다. 
// 