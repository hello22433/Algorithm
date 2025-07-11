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

        int maxTotalVal = Integer.MIN_VALUE;
        int possibleMaxGoldCnt = Integer.MIN_VALUE;

        // 중심점을 고른다.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                for (int k = 0; k < n; k++) {
                    // 넘어가지 않는 경우에 한해서 채굴한 금의 값을 합한다. 비용도 합한다.
                    int goldValSum = 0;
                    int goldCnt = 0;
                    int cost = 0;
                    int totalVal = goldValSum - cost;

                    // 마름모 길이가 0이라 중심점 자체가 마름모인 경우
                    if (k == 0) {
                        if (grid[i][j] == 1) {
                            goldValSum += M;
                        }
                        cost = 1;
                        goldCnt = 1;
                        totalVal = goldValSum - cost;

                        if (totalVal >= maxTotalVal) {
                            maxTotalVal = Math.max(maxTotalVal, totalVal);
                            possibleMaxGoldCnt = Math.max(possibleMaxGoldCnt, goldCnt);
                        }

                        continue;
                    }

                    // 네모 탐색
                    for (int a = i-(k-1); a <= i+(k-1); a++) {
                        for (int b = j-(k-1);  b <= j+(k-1); b++) {
                            if (a >= n || b >= n || a < 0 || b < 0) continue;
                            if (grid[a][b] == 1) {
                                goldValSum += M;
                                goldCnt++;
                            }
                            cost++;
                        }
                    }

                    // 마름모의 꼭지점을 더한다.
                    if ((i+k < n && j < n) && (i+k >= 0 && j >= 0) && grid[i+k][j] == 1) {
                        goldValSum += M;
                        cost++;
                        goldCnt++;
                    }
                    if ((i < n && j-k < n) && (i >= 0 && j-k >= 0) && grid[i][j-k] == 1) {
                        goldValSum += M;
                        cost++;
                        goldCnt++;
                    }
                    if ((i-k < n && j < n) && (i-k >= 0 && j >= 0) && grid[i-k][j] == 1) {
                        goldValSum += M;
                        cost++;
                        goldCnt++;
                    }
                    if ((i < n && j+k < n) && (i >= 0 && j+k >= 0) && grid[i][j+k] == 1) {
                        goldValSum += M;
                        cost++;
                        goldCnt++;
                    }

                    // 새로 구한 토탈밸류 값이 지금까지 구한 토탈밸류보다 크거나 같다면(골드 수가 달라질 수 있으므로)
                    // 토탈밸류와 최대골드수를 최댓값 갱신
                    totalVal = goldValSum - cost;
                    if (totalVal >= maxTotalVal) {
                        maxTotalVal = Math.max(maxTotalVal, totalVal);
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