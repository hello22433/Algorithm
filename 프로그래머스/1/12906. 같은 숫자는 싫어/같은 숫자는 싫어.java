import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Deque<Integer> result = new ArrayDeque<>();
        
        for (int a : arr) {
            if (result.isEmpty() || result.peekLast() != a) {
                result.addLast(a);
            }
        }
        
        return result.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}