
import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] office;
    static ArrayList<CCTV> cctvs = new ArrayList<>();

    // 상 우 하 좌
    static int[] dx = {-1, 0 , 1 ,0}; // 상 하
    static int[] dy = {0, 1 , 0 , -1}; // 우 좌

    static int min = Integer.MAX_VALUE;

    public static class CCTV {
        int x;
        int y;
        int type;

        CCTV (int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        office = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                office[i][j] = sc.nextInt();
                if (office[i][j] >= 1 && office[i][j] <= 5) {
                    cctvs.add(new CCTV(i, j, office[i][j]));
                }
            }
        }

        dfs(0, office);

        System.out.println(min);
    }

    private static void dfs(int cctvIdx, int[][] map) {
        if (cctvIdx == cctvs.size()) {
            min = Math.min(min, getBlindSpot(map));
            return;
        }

        CCTV cctv = cctvs.get(cctvIdx);

        for (int[] dirs : getDirections(cctv.type)) {
            int[][] copyMap = copy(map);

            for (int dir : dirs) {
                goStraight(cctv.x, cctv.y, dir, copyMap);
            }

            dfs(cctvIdx+1, copyMap);
        }
    }

    private static void goStraight(int x, int y, int dir, int[][] copyMap) {
        int nx = x;
        int ny = y;

        while (true) {
            nx += dx[dir];
            ny += dy[dir];

            if (nx < 0 || nx >= N || ny < 0 || ny >= M || copyMap[nx][ny] == 6) {
                break;
            }

            if (copyMap[nx][ny] == 0) {
                copyMap[nx][ny] = 7;
            }
        }
    }

    private static int[][] copy (int[][] map) {
        int[][] copyMap = new int[map.length][map[0].length];
        for (int i = 0; i < map.length; i++) {
            copyMap[i] = map[i].clone();
        }
        return copyMap;
    }

    private static ArrayList<int[]> getDirections(int type) {
        ArrayList<int[]> dirses = new ArrayList<>();

        // 0상 1우 2하 3좌
        switch (type) {
            case 1:
                dirses.add(new int[]{0});
                dirses.add(new int[]{1});
                dirses.add(new int[]{2});
                dirses.add(new int[]{3});
                break;
            case 2:
                dirses.add(new int[]{0, 2});
                dirses.add(new int[]{1, 3});
                break;
            case 3:
                dirses.add(new int[]{0, 1});
                dirses.add(new int[]{1, 2});
                dirses.add(new int[]{2, 3});
                dirses.add(new int[]{3, 0});
                break;
            case 4:
                dirses.add(new int[]{3, 0, 1});
                dirses.add(new int[]{0, 1, 2});
                dirses.add(new int[]{1, 2, 3});
                dirses.add(new int[]{2, 3, 0});
                break;
            case 5:
                dirses.add(new int[]{0, 1, 2, 3});
                break;
        }

        return dirses;
    }

    private static int getBlindSpot(int[][] map) {
        int value = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    value++;
                }
            }
        }
        return value;
    }
}



// 모든 씨씨티비를 하나씩 돌려본다.
// 돌리기함수
// 돌렸을때 새로운 맵 반환 함수
// 모든 씨시티비마다 4방향으로 돌려보아야 한다.
// 5번이면 넘어간다.
// 처음에는 모두 위를 보는 걸로 시작한다.
// 맵을 탐색하면서 카메라를 발견하면 4방향 모두 돌려본다. 각각에서