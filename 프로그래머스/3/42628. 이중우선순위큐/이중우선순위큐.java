import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        
        // PriorityQueue<Integer> minPq = new PriorityQueue<>();
        // PriorityQueue<Integer> maxPq = new PriorityQueue<>((a,b) -> {
        //     return b-a;
        // });
        TreeSet<Integer> dq = new TreeSet<>();
        
        for (String op : operations) {
            String operation = op.split(" ")[0];
            int num = Integer.parseInt(op.split(" ")[1]);
            
            if ("D".equals(operation)) {
                if (dq.isEmpty()) continue;
                
                if (num == 1) {
                    dq.pollLast();
                } else {
                    dq.pollFirst();
                }
            } else {
                dq.add(num);
            }
        }
        
        int[] result = new int[]{0,0};
        
        if (!dq.isEmpty()) {
            result[0] = dq.last(); // 최댓값
            result[1] = dq.first(); // 최솟값
        }
            
        return result;
    }
}

// 