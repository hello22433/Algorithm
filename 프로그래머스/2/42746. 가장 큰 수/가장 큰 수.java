import java.util.*;

class Solution {
    
    public String solution(int[] numbers) {
        
        Integer[] arr = Arrays.stream(numbers)
            .boxed()
            .toArray(Integer[]::new);
        
        Arrays.sort(arr, (a,b) -> {
            String sa = String.valueOf(a);
            String sb = String.valueOf(b);
            return (sb + sa).compareTo(sa + sb);
        });
        
        StringBuilder sb = new StringBuilder();
        for (Integer a : arr) {
            if (a == 0 && sb.length() == 0) continue; 
            sb.append(String.valueOf(a));
        }
        if (sb.length() == 0) sb.append("0");
        
        return sb.toString();
    }
    
}