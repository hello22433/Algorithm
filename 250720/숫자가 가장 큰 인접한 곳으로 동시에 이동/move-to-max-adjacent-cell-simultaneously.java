import java.util.Scanner;
public class Main {
    static int n,m,t;
    static int[][] grid, cntMarblesOnGrid, nextCntMarblesOnGrid, marbles;

    // 상 하 좌 우 0 1 2 3
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        t = sc.nextInt();
        grid = new int[n][n];
        cntMarblesOnGrid = new int[n][n];
        nextCntMarblesOnGrid = new int[n][n];
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        marbles = new int[m][2];
        
        for (int i = 0; i < m; i++) {
            marbles[i][0] = sc.nextInt()-1;
            marbles[i][1] = sc.nextInt()-1;
            cntMarblesOnGrid[marbles[i][0]][marbles[i][1]] = 1;
        }
        // Please write your code here.

        simulateMoveMarbles();
        int result = countMarbles();
        System.out.print(result);
    }

    public static int countMarbles() {
        int sum = 0;
        for (int i = 0 ; i < n; i++) {
            for (int j = 0 ; j < n; j++) {
                if (cntMarblesOnGrid[i][j] == 1)
                    sum++;
            }
        }
        return sum;
    }

    public static boolean isInBound(int x, int y) {
        if (x >= 0 && x < n && y >= 0 && y < n) return true;
        return false;
    }

    public static void simulateMoveMarbles() {
        for (int T = 0; T < t; T++) {

            nextCntMarblesOnGrid = new int[n][n];
            
            // 시간마다 모든 구슬들의 상하좌우를 모두 탐색해야 함.
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (cntMarblesOnGrid[i][j] == 1) {
                        moveMarble(i, j);
                    }
                }
            }

            cloneCntMarblesOnGrid();

            boomOverlap();
        }
    }

    public static void cloneCntMarblesOnGrid() {
        for (int i = 0;  i < n; i++) {
            for (int j = 0; j < n; j++) {
                cntMarblesOnGrid[i][j] = nextCntMarblesOnGrid[i][j];
            }
        }
    }

    public static void boomOverlap() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (cntMarblesOnGrid[i][j] >= 2) 
                    cntMarblesOnGrid[i][j] = 0;
            }
        }
    }

    public static void moveMarble(int x , int y) {
        
        int maxValue = findMaxValue(x, y);
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (isInBound(nx, ny) && grid[nx][ny] == maxValue) {
                nextCntMarblesOnGrid[nx][ny] += 1;
            }
        }
    }

    public static int findMaxValue(int x, int y) {
        int maxValue = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (isInBound(nx, ny))
                maxValue = Math.max(maxValue, grid[nx][ny]);
        }
        return maxValue;
    }
}

// 가장 큰 수 ! 
// 상하좌우를 모두 탐색해야 함. -> 만약 가장 큰 수가 여러 개라면, 상하좌우 순으로 해야 한다.
// 즉, 먼저 상하좌우의 최댓값 구함 -> 다시 상하좌우를 탐색하면서 최댓값과 같은 값이 나오면 그 좌표로 이동한다.