
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[] selected;
    static int N;
    static int M;
    static int minDistance = Integer.MAX_VALUE;
    static List<int[]> homes = new ArrayList<>();
    static List<int[]> chickens = new ArrayList<>();


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N+1][N+1];

        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < N+1; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 1) homes.add(new int[]{i, j});
                else if (map[i][j] == 2) chickens.add(new int[]{i, j});
            }
        }

        selected = new boolean[chickens.size()];
        dfs(0, 0);
        System.out.println(minDistance);
    }

    private static void dfs(int start, int ChickCount) {
        if (ChickCount == M) {
            calculateDistance();
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            selected[i] = true;
            dfs(i+1, ChickCount+1);
            selected[i] = false;
        }
    }

    private static void calculateDistance() {
        int DistanceSum = 0;

        for (int[] home : homes) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < chickens.size(); i++) {
                if (selected[i]) {
                    int[] chick = chickens.get(i);
                    int dist = Math.abs(chick[0] - home[0]) + Math.abs(chick[1] - home[1]);
                    min = Math.min(min, dist);
                }
            }
            DistanceSum += min;
        }

        minDistance = Math.min(minDistance, DistanceSum);
    }
}




// 남겨야할 치킨집개수 -> 어떤 치킨집을 남겨야 할까?
// 남기는 쪽에 치킨집을 추가한다.
// 만약 M개가 된다면 도시의 치킨거리를 계산한다.
// 백트래킹으로 모든 치킨거리를 계산하여 가장 짧은 거리를 갱신한다.
//
// 계산할떄 탐색으로 집을 찾는다.
// 집을 찾으면 Bfs로 가장 가까운 치킨집을 찾는다. (selected로 찾는다.)
// 거리를 계산해서 bucket에 더한다.
//