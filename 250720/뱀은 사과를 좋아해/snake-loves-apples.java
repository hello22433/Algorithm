import java.util.*;
public class Main {

    static int n,m,k;
    static int[][] board;
    static char[] dirInfo;
    static int[] dirHowMuchInfo;

    // 동 남 서 북 0 1 2 3
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();

        board = new int[n][n];
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt()-1;
            int y = sc.nextInt()-1;
            board[x][y] = 1;
        }

        // 00xx
        // 00xx // 움직이는 행위를 먼저 하고 -> 그 위치에 아직 꼬리가 남아있는지를 체크해야 함.

        dirInfo = new char[k];
        dirHowMuchInfo = new int[k];
        for (int i = 0; i < k; i++) {
            char d = sc.next().charAt(0);
            int p = sc.nextInt();

            dirInfo[i] = d;
            dirHowMuchInfo[i] = p;
        }

        int spentTime = simulateSnakeEatApples();
        System.out.print(spentTime);
    }

    public static int simulateSnakeEatApples() {
        int x = 0;
        int y = 0;
        int spentTime = 0;
        int dir = -1;

        board[x][y] = 2;

        Deque<int[]> snake = new LinkedList<>();
        snake.addLast(new int[]{x, y});

        for (int i = 0; i < k; i++) {
            if (dirInfo[i] == 'R') dir = 0;
            if (dirInfo[i] == 'D') dir = 1;
            if (dirInfo[i] == 'L') dir = 2;
            if (dirInfo[i] == 'U') dir = 3;

            for (int t = 0; t < dirHowMuchInfo[i]; t++) {
                // 한 칸 갈 때마다, spentTime++
                spentTime++;

                // 방향에 맞게 새로운 이동 좌표를 구한다.
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                // 아웃바운드면 타임을 리턴한다. 
                // 이동하는 위치에 뱀이 있는 경우는, 움직인 후에 고려해야 한다.
                if (!inBound(nx, ny)) {
                    return spentTime;
                }

                // 이동할 수 있으면! 이동 한 후에, 덱 앞에 해당 좌표를 추가하고, 해당 좌표의 값을 저장해둔다(링고) 후에, 해당 보드의 좌표를 2로 변경한다.
                // 후에, 저장해둔 값이 1이 아니라면 덱 뒤의 하나의 좌표를 뽑아서poll, 해당 좌표를 0으로 만든다. 
                x = nx;
                y = ny;
                int isLingo = board[x][y];
                board[x][y] += 2;
                snake.addFirst(new int[]{x,y});

                int[] lastTail = snake.peekLast();
                if (isLingo != 1) {
                    int[] lingoXY = snake.pollLast();
                    board[lingoXY[0]][lingoXY[1]] -= 2;
                } else {
                    board[x][y] -= 1;
                }

                // 사과를 먹는 것까지 고려하였는데 만약, 꼬리가 있다면 부딪힘.
                if (board[x][y] > 2) {
                    return spentTime;
                }
            }
        }

        return spentTime;
    }

    public static boolean inBound(int x, int y) {
        if (x >= 0 && x < n && y >= 0 && y < n) return true;
        return false;
    }
}

// 