

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;


public class Main {

    static int R,C;
    static char[][] map;
    static boolean[][] visited;
    static int[] dy = {-1, 0, 1}; // 위, 가운데, 아래
    static int[] dx = {1, 1, 1};
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < R; i++) {
            if (map[i][0] == '.') {
                if (dfs(i, 0)) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }

    private static boolean dfs(int y, int x) {
        visited[y][x] = true;

        if (x == C-1) return true;

        for (int i = 0; i < 3; i++) {
            int newY = y + dy[i];
            int newX = x + dx[i];

            if (newY >= 0 && newY < R && !visited[newY][newX] && map[newY][newX] == '.') {
                if (dfs(newY, newX)) {
                    return true;
                }
            }
        }
        return false;
    }

}

// 모든 파이프라인은 겹치면 안된다.
// 파이프라인은 오른쪽 대각위, 오른쪽, 대각아래로 연결될 수 있다.
// BFS로 풀어본다. 5000000
//