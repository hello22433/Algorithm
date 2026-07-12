import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int count = 0;
        
        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < priorities.length; i++) {
            q.offer(new int[]{i, priorities[i]});
        }
        
        Arrays.sort(priorities);
        int maxIdx = priorities.length - 1;
        
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curIdx = cur[0];
            int curPrior = cur[1];
            int maxPriority = priorities[maxIdx];
            
            if (curPrior == maxPriority) {
                count++;
                
                if (curIdx == location) {
                    return count;
                }
                maxIdx--;
            } else {
                q.offer(cur);
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