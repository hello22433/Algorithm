import java.util.*;

public class Main {
    static int N; // 미로의 크기
    static int startX, startY; // 시작 위치 (0based)
    static char[][] maze;
    static int[][][] visited; // 3차원 방문 체크 (y, x, 방향)

    // 방향: 동(0), 남(1), 서(2), 북(3)
    static int[] dx = {0, 1, 0, -1}; // x좌표 변화
    static int[] dy = {1, 0, -1, 0}; // y좌표 변화

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. 입력 받기
        N = sc.nextInt();
        startX = sc.nextInt() - 1; // 문제는 1based 입력하므로 -1 처리
        startY = sc.nextInt() - 1;

        maze = new char[N][N];
        for (int i = 0; i < N; i++) {
            String line = sc.next();
            maze[i] = line.toCharArray();
        }

        // 2. 시뮬레이션 실행
        int result = simulateEscape();

        // 3. 결과 출력
        System.out.println(result);
    }

    // 미로 탈출 시뮬레이션 함수
    public static int simulateEscape() {
        visited = new int[N][N][4]; // 방향까지 포함한 방문 체크
        int x = startX;
        int y = startY;
        int dir = 0; // 시작 방향은 '동쪽'
        int steps = 1; // 시작 위치도 포함

        while (true) {
            // 현재 위치와 방향이 중복되면 무한 루프 -> 탈출 불가능
            if (visited[x][y][dir] == 1) return -1;
            visited[x][y][dir] = 1;

            // 현재 방향으로 한 칸 이동
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            // 1) 범위를 벗어나면 탈출 성공
            if (!isInBounds(nx, ny)) return steps;

            // 2) 이동하려는 곳이 벽이면 -> 왼쪽으로 회전
            if (maze[nx][ny] == '#') {
                dir = turnLeft(dir);
                continue;
            }

            // 3) 이동 가능 -> 이동하려는 곳 오른쪽에 벽이 있으면 그냥 전진
            int rightDir = turnRight(dir);
            int rx = nx + dx[rightDir];
            int ry = ny + dy[rightDir];

            if (isInBounds(rx, ry) && maze[rx][ry] == '#') {
                x = nx;
                y = ny;
                steps++;
            }

            // 4) 오른쪽에 벽이 없다면 -> 이동 + 오른쪽으로 방향 전환
            else {
                x = nx;
                y = ny;
                dir = rightDir;
                steps++;
            }
        }
    }

    // 미로 범위 확인 함수
    public static boolean isInBounds(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    // 왼쪽 회전
    public static int turnLeft(int dir) {
        return (dir + 3) % 4;
    }

    // 오른쪽 회전
    public static int turnRight(int dir) {
        return (dir + 1) % 4;
    }
}