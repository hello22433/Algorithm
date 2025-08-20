class Solution {
    int solution(int[][] land) {
        
        for(int i = 1; i < land.length; i++) {
            
            for (int j = 0; j < 4; j++) {
                int max = 0;
                for (int k = 0; k < 4; k++) {
                    if (k == j) {continue;}
                    max = Math.max(max, land[i][j] + land[i-1][k]);
                }
                land[i][j] = max;
            }
        }
        
        int answer = 0;
        for (int i = 0; i < 4; i++) {
            answer = Math.max(answer, land[land.length -1][i]);
        }
        return answer;
    }
}

// DP
// 첫행부터 마지막행까지 각행에 최댓값을 대입하며 진행한다. 
// 