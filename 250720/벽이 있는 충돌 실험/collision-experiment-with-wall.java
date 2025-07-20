import java.util.Scanner;
public class Main {
    static int N, M, x, y;
    static char d;
    static int[][] board, newBoard, cntBombsOnBoard, nextCntBombsOnBoard;

    // 동 남 서 북 0 1 2 3 
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-- > 0) {
            N = sc.nextInt();
            M = sc.nextInt();
            board = new int[N][N];
            newBoard = new int[N][N];
            cntBombsOnBoard = new int[N][N];
            nextCntBombsOnBoard = new int[N][N];
            for (int i = 0; i < M; i++) {
                x = sc.nextInt()-1;
                y = sc.nextInt()-1;
                d = sc.next().charAt(0);

                if (d == 'R') board[x][y] = 0;
                else if (d == 'D') board[x][y] = 1;
                else if (d == 'L') board[x][y] = 2;
                else if (d == 'U') board[x][y] = 3;

                cntBombsOnBoard[x][y] = 1;
            }
            // Please write your code here.

            for (int i = 0; i <= 2 * N + 1; i++)
                simulateMoves();

            int result = cntRemainBombs();
            System.out.println(result);
        }
    }

    public static void cloneCntBoard() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                cntBombsOnBoard[i][j] = nextCntBombsOnBoard[i][j];
            }
        }
    }

    public static void cloneBoard() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = newBoard[i][j];
            }
        }
    }

    public static void boomOverLaps() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (nextCntBombsOnBoard[i][j] >= 2) 
                    nextCntBombsOnBoard[i][j] = 0;
            }
        }
    }

    public static void simulateMoves() {
        nextCntBombsOnBoard = new int[N][N];
        newBoard = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (cntBombsOnBoard[i][j] == 1) {
                    simulateMove(i, j);
                }
            }
        }

        boomOverLaps();
        cloneCntBoard();
        cloneBoard();
    }

    public static void simulateMove(int x, int y) {
        int dir = board[x][y];
        int nx = x + dx[dir];
        int ny = y + dy[dir];

        if (isInBound(nx, ny)) {
            newBoard[nx][ny] = dir;
            nextCntBombsOnBoard[nx][ny] += 1;
        } else {
            newBoard[x][y] = (dir + 2) % 4;
            nextCntBombsOnBoard[x][y] += 1;
        }
    }

    public static boolean isInBound(int x, int y) {
        if (x >= 0 && x < N && y >= 0 && y < N) return true;
        return false;
    }

    public static int cntRemainBombs() {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (cntBombsOnBoard[i][j] == 1) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}

// 