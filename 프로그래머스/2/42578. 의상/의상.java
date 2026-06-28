import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        
        for (String[] cloth : clothes) {
            String clothType = cloth[1];
            String clothName = cloth[0];
            
            map.put(clothType, map.getOrDefault(clothType, 0) + 1);
        }
        
        int totalMixture = 1;
        for (Map.Entry<String, Integer> m : map.entrySet()) {
            totalMixture *= m.getValue()+1;
        }
        
        return totalMixture-1;
    }
}

// 한 종류의 의상 중 하나만 가능
// 최소 1개
// 4 + 2 * 1 * 1 
