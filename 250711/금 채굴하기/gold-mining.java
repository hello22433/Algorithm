import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int M = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        // Please write your code here.

        int possibleMaxGoldCnt = 0;

        int goldValSum = 0;
        int goldCnt = 0;
        int totalVal = 0;

        // 중심점을 고른다.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                for (int k = 0; k < n; k++) {
                    // 넘어가지 않는 경우에 한해서 채굴한 금의 값을 합한다. 비용도 합한다.
                    goldValSum = 0;
                    goldCnt = 0;

                    // 마름모 탐색
                    for (int a = 0; a < n; a++) {
                        for (int b = 0;  b < n; b++) {
                            if (Math.abs(i-a) + Math.abs(j-b) <= k && grid[a][b]==1) {
                                goldValSum += M;
                                goldCnt++;
                            }
                        }
                    }

                    // 새로 구한 토탈밸류 값이 지금까지 구한 토탈밸류보다 크거나 같다면(골드 수가 달라질 수 있으므로)
                    // 토탈밸류와 최대골드수를 최댓값 갱신
                    totalVal = goldValSum - (int)(Math.pow(k, 2) + Math.pow(k+1, 2));
                    if (totalVal >= 0) {
                        possibleMaxGoldCnt = Math.max(possibleMaxGoldCnt, goldCnt);
                    }
                }
            }
        }

        System.out.print(possibleMaxGoldCnt);
    }
}

// 채굴하다
// 최대한 많이
// 마름모 모양으로 단 한 번
// 중심점을 기준으로, K번 이내로 상하좌우 인접한 곳으로 이동하는것을 반복
// 
// 채굴비용 : 마름모 안의 격자 갯수 (K^2 + (K+1)^2)
// 
// 어떻게 움직일 것인가?
// k 0일땐 cost도 1, 해당 칸의 수만을 구하고 넘어간다. 
// i-(k-1) ~ i+(k-1) , j-(k-1) ~ j+(k-1) 만큼 네모를 탐색한다. 
// 이후 i+k j , i j-k , i-k j , i j+k 를 더한다. 
// 

// 네모 만들기 -> bfs로 k만큼 움직이기
// bfs 그래프를 만든다. (grid와 똑같은 크기)
// k를 bfs그래프의 중심점에 넣는다. 
// 