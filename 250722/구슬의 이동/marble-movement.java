import java.util.*;
public class Main {
    static int n,m,t,k;
    static PriorityQueue<Bead>[][] board;
    static PriorityQueue<Bead>[][] nextBoard;

    // 동 남 서 북 0 1 2 3
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        t = sc.nextInt();
        k = sc.nextInt();

        board = makeNewBoard();

        for (int i = 1; i <= m; i++) {
            int num = i;
            int r = sc.nextInt()-1;
            int c = sc.nextInt()-1;
            char d = sc.next().charAt(0);
            int v = sc.nextInt();

            int dir = -1;
            if (d == 'R') dir = 0;
            if (d == 'D') dir = 1;
            if (d == 'L') dir = 2;
            if (d == 'U') dir = 3;

            board[r][c].offer(new Bead(num, v, dir));
        }

        simulateBeadsMoves();
        int result = cntRemainBeads();
        System.out.print(result);
    }

    public static void simulateBeadsMove(int x, int y) {
        
        while (!board[x][y].isEmpty()) {

            Bead bead = board[x][y].poll();
            int curX = x;
            int curY = y;
            int dir = bead.d;

            for (int i = 0; i < bead.speed; i++) {
                int nx = curX + dx[dir];
                int ny = curY + dy[dir];

                if (inBound(nx, ny)) {
                    curX = nx;
                    curY = ny;
                } else {
                    dir = (dir + 2) % 4;
                    curX += dx[dir];
                    curY += dy[dir];
                }
            }

            bead.d = dir;

            nextBoard[curX][curY].offer(bead);
        }
    }

    public static boolean inBound(int x, int y) {
        if (x >= 0 && x < n && y >= 0 && y < n) return true;
        return false;
    }

    public static void boomBeadsInNextBoard() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (nextBoard[i][j].size() > k) {
                    while (nextBoard[i][j].size() > k) {
                        nextBoard[i][j].poll();
                    }
                }
            }
        }
    }

    
    public static void simulateBeadsMoves() {
        
        for (int T = 0; T < t; T++) {

            nextBoard = makeNewBoard();

            // 한 격자에서 구슬들을 찾으면 안에 있는 구슬들을 각각 움직인다.
            // pop으로 빼내서 움직인 다음, 목표 지점의 큐에 넣으면 된다.
            // 
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j].size() != 0) {
                        simulateBeadsMove(i, j);
                    }
                }
            }

            boomBeadsInNextBoard();

            board = nextBoard;
        }
    }

    public static int cntRemainBeads() {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cnt += board[i][j].size();
            }
        }
        return cnt;
    }

    public static PriorityQueue<Bead>[][] makeNewBoard() {
         PriorityQueue<Bead>[][] newBoard = new PriorityQueue[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                newBoard[i][j] = new PriorityQueue<Bead>((a,b) -> {
                    if (a.speed == b.speed) {
                        return a.num - b.num;
                    }
                    return a.speed - b.speed;
                });
            }
        }

        return newBoard;
    }

}

class Bead {
    int num;
    int speed;
    int d;

    Bead(int num, int speed, int d) {
        this.num = num;
        this.speed = speed;
        this.d = d;
    }
}


// M
// N x N
// 방향 바뀌기는 시간 소요 x
// 매 초마다 움직임
// 움직이고 난 후, 같은 위치에 K개 초과하는 구슬이 있다면,
// 우선순위가 높은 구슬 K개만 살아남음
// 우선순위 높음? 구술의 속도가 빠를수록 높음
// 속도가 일치할 경우, 구슬 번호 더 큰게 높음 (우선순위 큐 : 오히려 정렬 기준을 오름차순으로 하여 우선순위 낮은 애가 나오도록 해야 함) 
// 시작시점으로부터, 정수시간만큼 지난 경우에만 구슬의 충돌을 따진다.
// 소멸은 충돌 그 즉시 일어남. 즉 가장 먼저 계산이 되어야 한다.
// T초 후 격자에 남은 구슬의 개수


// 보드 각각에 우선순위 큐가 있어야 한다.
// 
// 속도만큼 움직인다
// 보드 각각을 체크하고 사이즈가 K 초과면 K가 될 때까지 우선순위 낮은 걸 삭제한다. 
// 모두 움직이고 터진 후, 보드에 남은 구슬을 체크