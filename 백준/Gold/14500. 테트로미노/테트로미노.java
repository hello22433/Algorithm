
import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[][] arr;
    static boolean[][] visited;
    static int max = Integer.MIN_VALUE;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, arr[i][j], 1);
                visited[i][j] = false;
            }
        }

        System.out.println(max);
    }

    private static void dfs(int x, int y, int sum, int depth) {
        if (depth == 4) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny]) {
                continue;
            }

            if (depth == 2) {
                visited[nx][ny] = true;
                dfs(x, y, sum + arr[nx][ny], depth + 1);
                visited[nx][ny] = false;
            }

            visited[nx][ny] = true;
            dfs(nx, ny, sum + arr[nx][ny], depth + 1);
            visited[nx][ny] = false;
        }

    }
}




//