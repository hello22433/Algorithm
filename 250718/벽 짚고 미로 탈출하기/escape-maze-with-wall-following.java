import java.util.*;

public class Main {
    static int N;
    static int startX, startY;
    static char[][] map;
    static int[][][] visited;

    static int[] dy = {0, 1, 0, -1}; // 동, 남, 서, 북
    static int[] dx = {1, 0, -1, 0};

    public static boolean isBound(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < N;
    }

    public static int mazeMap() {
        visited = new int[N][N][4];
        int y = startY;
        int x = startX;
        int dir = 0; // 시작 방향: 동쪽
        int cnt = 1;

        while (true) {
            if (visited[y][x][dir] == 1) return -1;
            visited[y][x][dir] = 1;

            int ny = y + dy[dir];
            int nx = x + dx[dir];

            if (!isBound(ny, nx)) return cnt;

            if (map[ny][nx] == '#') {
                dir = (dir + 3) % 4; // 왼쪽으로 회전
            } else {
                int rightDir = (dir + 1) % 4;
                int ry = ny + dy[rightDir];
                int rx = nx + dx[rightDir];

                if (isBound(ry, rx) && map[ry][rx] == '#') {
                    y = ny;
                    x = nx;
                    cnt++;
                } else {
                    y = ny;
                    x = nx;
                    dir = rightDir;
                    cnt++;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        startY = sc.nextInt() - 1;
        startX = sc.nextInt() - 1;

        map = new char[N][N];
        for (int y = 0; y < N; y++) {
            String line = sc.next();
            for (int x = 0; x < N; x++) {
                map[y][x] = line.charAt(x);
            }
        }

        System.out.println(mazeMap());
    }
}
