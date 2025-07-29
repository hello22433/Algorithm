import java.util.Scanner;

public class Main {
    static boolean[] visited;
    static int[][] cost;
    static int n;
    static int minCost = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        visited = new boolean[n];
        cost = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = sc.nextInt();
            }
        }
        // Please write your code here.

        dfs(0, 0, 0);
        System.out.print(minCost);
    }

    public static void dfs(int curIdx, int depth, int sumCost) {
        if (depth == n-1) {
            
            // 마지막 1로 가는 것까지 구현이 되어야 함
            // System.out.println(curIdx);
            if (cost[curIdx][0] != 0) {
                sumCost += cost[curIdx][0];
                minCost = Math.min(minCost, sumCost);
            }
            
            return;
        }

        // 2부터 n까지 순열 탐색을 해야 한다. (인덱스처리해야 하니까 -1)
        for (int num = 2; num <= n; num++) {
            int numToIdx = num-1;
            if (!visited[numToIdx]) {
                visited[numToIdx] = true;
                if (cost[curIdx][numToIdx] != 0)
                    dfs(numToIdx, depth + 1, sumCost + cost[curIdx][numToIdx]);
                visited[numToIdx] = false;
            }
        }
    }
}

// 1 ~  모든 지점을 정확히 딱 한 번씩만 방문 -> 1번으로 돌아옴
// i~j : Aij
// 모든 정점을 겹치지 않게 방문
// 하고 돌아오는데 필요한 최소 비용의 합

// 현재 위치가 cost[depth][]
// 순열을 고려해야 한다. 다만 첫번째 1과 마지막 1은 유지되어야 한다.