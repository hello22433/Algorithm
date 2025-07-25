import java.util.*;
public class Main {
    static Bead[][] board;
    static Bead[][] nextBoard;
    static Queue<int[]> beadsXY;
    
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static int n,m,t;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        t = sc.nextInt();

        board = new Bead[n][n];
        beadsXY = new LinkedList<>();

        for (int i = 1; i <= m; i++) {
            int num = i;
            int r = sc.nextInt()-1;
            int c = sc.nextInt()-1;
            char d = sc.next().charAt(0);
            int w = sc.nextInt();
            int dir = -1;

            if (d == 'R') dir = 0;
            if (d == 'D') dir = 1;
            if (d == 'L') dir = 2;
            if (d == 'U') dir = 3;

            board[r][c] = new Bead(dir, w, num);
            beadsXY.offer(new int[]{r,c});
        }

        simulateMoves();
        int remainBeads = cntRemainBeads();
        int heaviestWeight = findHeaviestBeadWeight();

        System.out.print(remainBeads + " " + heaviestWeight);
    }

    public static int findHeaviestBeadWeight() {
        int maxW = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != null)
                    maxW = Math.max(maxW, board[i][j].w);
            }
        }

        return maxW;
    }

    public static int cntRemainBeads() {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != null) cnt++;
            }
        }
        return cnt;
    }

    public static void simulateMoves() {

        for (int T = 0; T < t; T++) {
            int qSize = beadsXY.size();
            nextBoard = new Bead[n][n];

            for (int i = 0; i < qSize; i++) {
                int[] poller = beadsXY.poll();
                int x = poller[0];
                int y = poller[1];

                simulateMove(x,y); 
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // System.out.print(nextBoard[i][j] + " ");
                    board[i][j] = nextBoard[i][j];
                    if (board[i][j] != null) beadsXY.offer(new int[]{i, j});
                }
                // System.out.println();
            }
        }
    }

    public static void simulateMove(int x, int y) {
        
        Bead bead = board[x][y];

        int dir = bead.d;

        int nx = x + dx[dir];
        int ny = y + dy[dir];

        if (inBound(nx, ny)) {
            if (nextBoard[nx][ny] != null) {
                Bead existedBead = nextBoard[nx][ny];

                if (existedBead.num < bead.num) {
                    nextBoard[nx][ny] = new Bead(bead.d, existedBead.w + bead.w, bead.num);
                } else {
                    nextBoard[nx][ny] = new Bead(existedBead.d, existedBead.w + bead.w, existedBead.num);
                }
            } else {
                nextBoard[nx][ny] = bead;
            }
        } else {
            nextBoard[x][y] = new Bead((bead.d+2)%4, bead.w, bead.num);
        }

        
    }

    public static boolean inBound(int x ,int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}

class Bead {
    int d;
    int w;
    int num;

    Bead(int d, int w, int num) {
        this.d = d;
        this.w = w;
        this.num = num;
    }
}

// 충돌 -> 합쳐짐 : 무게는 모든 구슬의 합 , 방향은 가장 큰 번호를 따름 (하나씩 합해질때마다 갱신한다.)
// 