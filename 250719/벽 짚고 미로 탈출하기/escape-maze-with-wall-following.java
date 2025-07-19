import java.util.*;

public class Main {
    static int N;
    static int startX;
    static int startY;
    static char[][] maze;

    // 동 남 서 북 0123
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    // 처음엔 오른쪽이라서 0인덱스
    static int dir = 0; 
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        startX = sc.nextInt()-1;
        startY = sc.nextInt()-1;
        maze = new char[N][N];

        for (int i = 0; i < N; i++) {
            String line = sc.next();
            maze[i] = line.toCharArray();
        }

        int result = simulateEscape();

        System.out.print(result);

    }

    public static int simulateEscape() {

        int x = startX;
        int y = startY; 
        int steps = 1;

        // 한 칸에 방향 4개의 방문 여부를 다 저장한다.
        boolean[][][] visited = new boolean[N][N][4];

        while (true) {
            // 이미 방문한 곳에 다시 온 것이라면, 무한 루프거나 모든 방향이 막힌 곳이라는 것. => -1 반환
            if (visited[x][y][dir]) return -1;
            visited[x][y][dir] = true;

            // 바라보는 방향으로 한 발자국 간다.
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            // 만약 움직인 곳이 아웃바운드면 탈출!
            if (!inBound(nx, ny)) {
                return steps;
            }

            // 움직인 곳에 벽이 있다면 움직일 수 없음 -> 왼쪽으로 회전해서 다음 루프로 시작해야 함
            if (maze[nx][ny] == '#') {
                dir = turnLeft();
                continue;
            }

            // 움직이려는 곳의 오른쪽을 살펴보아야 한다.
            // 인바운드가 아니거나 벽이 있으면 움직이기만 하면 되고, 인바운드면서 벽이 없으면 추가로 오른쪽으로 회전해야 함.
            int rightDir = turnRight();
            int rxOfnx = nx + dx[rightDir];
            int ryOfny = ny + dy[rightDir];

            steps++;
            x = nx;
            y = ny;

            if (inBound(rxOfnx, ryOfny) && maze[rxOfnx][ryOfny] != '#') {
                dir = rightDir;
            }
        }
    }

    public static int turnLeft() {
        int ndir = (dir + 3) % 4;
        return ndir;
    }

    public static int turnRight() {
        int ndir = (dir + 1) % 4;
        return ndir;
    }

    public static boolean inBound(int x, int y) {
        if (x >= 0 && x < N && y >= 0 && y < N) return true;
        return false;
    }

}