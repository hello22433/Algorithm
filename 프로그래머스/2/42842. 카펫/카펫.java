class Solution {
    public int[] solution(int brown, int yellow) {
        for (int i = 1; i <= yellow; i++) {
            int m = i;
            
            if (yellow % m != 0) continue;
            int r = yellow/m;
            
            int calBrownCnt = m * 2 + (yellow / m + 2) * 2;
                
            if (brown == calBrownCnt) return new int[]{r+2, m+2};
        }
        
        return new int[]{0};
    }
}

// 세로로 한 줄로 하는 것부터 시작해서, 가로로 한 줄까지 이동한다.
// 세로가 두 줄로 늘어나면, 가로는 n/2가 된다.
// 즉, 세로가 m 줄이면, 가로는 전체/m 줄이 된다.
// m은 최대 전체 yellow 개수 만큼 된다. (이후 y로 통칭)
// 만약 세로줄이 1줄이라면 갈색의 개수는 2개이다. 2줄이라면 갈색의 개수는 4개이다. 3줄이라면 6개이다.
// 즉, 세로의 갈색의 개수는 m * 2이다.
// 가로줄이 1줄이라면 (1 + 2)2 이다. 2줄이라면 (2 + 2)2 이다. 즉, (y/m + 2)2 가 가로의 갈색의 개수이다.