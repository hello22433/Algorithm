import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        
        int[] result = new int[commands.length];
        int resultIdx = 0;
        for (int a = 0; a < commands.length; a++) {
            int[] command = commands[a];
            
            int s = command[0] - 1;
            int e = command[1] - 1;
            int k = command[2] - 1;
            
            int[] bucket = new int[e-s+1];
            int bucketIdx = 0;
            for (int i = s; i <= e; i++) {
                bucket[bucketIdx++] = array[i];
            }
            
            Arrays.sort(bucket);
            
            result[resultIdx++] = bucket[k];
        }
        
        return result;
    }
}

// array 의 i ~ j(1based) 자르고 -> 정렬 -> k 번째 수
// 