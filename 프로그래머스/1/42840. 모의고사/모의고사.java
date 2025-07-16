class Solution {
    public int[] solution(int[] answers) {
        
        int[] one = new int[]{1,2,3,4,5};
        int[] two = new int[]{2,1,2,3,2,4,2,5};
        int[] thr = new int[]{3,3,1,1,2,2,4,4,5,5};
        
        int oneCnt = 0;
        int twoCnt = 0;
        int thrCnt = 0;
        
        int oneIdx = 0;
        int twoIdx = 0;
        int thrIdx = 0;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == one[oneIdx++]) oneCnt++;
            if (answers[i] == two[twoIdx++]) twoCnt++;
            if (answers[i] == thr[thrIdx++]) thrCnt++;
            
            if (oneIdx >= one.length) oneIdx = 0;
            if (twoIdx >= two.length) twoIdx = 0;
            if (thrIdx >= thr.length) thrIdx = 0;
        }
        
        int maxCnt = 0;
        maxCnt = Math.max(maxCnt, oneCnt);
        maxCnt = Math.max(maxCnt, twoCnt);
        maxCnt = Math.max(maxCnt, thrCnt);
        
        int arrSize = 0;
        if (oneCnt == maxCnt) arrSize++;
        if (twoCnt == maxCnt) arrSize++;
        if (thrCnt == maxCnt) arrSize++;
        
        int[] resultArr = new int[arrSize];
        int idx = 0;
        if (oneCnt == maxCnt) resultArr[idx++] = 1;
        if (twoCnt == maxCnt) resultArr[idx++] = 2;
        if (thrCnt == maxCnt) resultArr[idx++] = 3;
        
        return resultArr;
    }
}

// 