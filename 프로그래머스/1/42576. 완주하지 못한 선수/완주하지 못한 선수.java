import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        Map<String, Integer> map = new HashMap<>();
        
        for (String part : participant) {
            map.put(part, map.getOrDefault(part, 0) + 1);
        }
        
        for (String com : completion) {
            map.put(com, map.get(com) - 1);
        }
        
        for (Map.Entry<String, Integer> m : map.entrySet()) {
            if (m.getValue() != 0) return m.getKey();
        }
        
        return "";
    }
}