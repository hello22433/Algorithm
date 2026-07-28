class Solution {
    static int answerCnt = 0;
    static int targetNum = 0;
    static int[] arr;
    
    public int solution(int[] numbers, int target) {
        targetNum = target;
        arr = numbers;
        
        dfs(0, 0);
        
        return answerCnt;
    }
    
    private void dfs(int sum, int startIdx) {
        // 종료조건 : startIdx가 마지막 인덱스를 초과했을때
        if (startIdx == arr.length) {
            // System.out.println(sum + " " + startIdx);
            if (targetNum == sum) answerCnt++;
            return;
        }
        
        // startIdx부터 끝까지 돈다. 대신 플러스와 마이너스를 한번씩 모두 돈다.
        dfs(sum + arr[startIdx], startIdx+1);
        dfs(sum - arr[startIdx], startIdx+1);
        
        
    }
}

// 