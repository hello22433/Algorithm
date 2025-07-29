import java.util.Scanner;

public class Main {
    static int n, m;
    static int minDistance = Integer.MAX_VALUE;
    static int[][] points;
    static boolean[] visited;
    static int[] xy;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        points = new int[n][2];
        visited = new boolean[n];
        xy = new int[m];
        for (int i = 0; i < n; i++) {
            points[i][0] = sc.nextInt();
            points[i][1] = sc.nextInt();
        }
        // Please write your code here.
        dfs(0, 0);
        System.out.print(minDistance);
    }

    public static void dfs(int startIdx, int depth) {
        if (depth == m) {
            int maxDistance = 0;

            for (int i = 0; i < m-1; i++) {
                for (int j = i+1; j < m; j++) {
                    int point1Idx = xy[i];
                    int point2Idx = xy[j];

                    int x1 = points[point1Idx][0];
                    int y1 = points[point1Idx][1];
                    int x2 = points[point2Idx][0];
                    int y2 = points[point2Idx][1];

                    int distance = (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2);
                    maxDistance = Math.max(maxDistance, distance);
                }
            }
            minDistance = Math.min(minDistance, maxDistance);

            return;
        }

        for (int i = startIdx; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                xy[depth] = i;
                dfs(i+1, depth+1);
                visited[i] = false;
            }
        }
    }
}


// N 중 M개를 적절히 선택
// 가장 먼 두 점 거리값을 최소화하라.
// 
// i의 인덱스를 골라서 int[2]에 넣는다.