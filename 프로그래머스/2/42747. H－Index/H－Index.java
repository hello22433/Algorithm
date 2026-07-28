import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        
        for (int i = 0; i < citations.length; i++) {
            int h = Math.min(citations[i], citations.length-1 - i + 1);
            if (h <= citations.length-1 - i + 1) {
                answer = Math.max(answer, h);
            }
        }
        
        return answer;
    }
}

// citations를 오름차순 정렬
// i 에서 lengh -1 까지 모두 포함해서 citations[i] 이상이면 그게 최댓값. -> 계속 갱신해나간다.