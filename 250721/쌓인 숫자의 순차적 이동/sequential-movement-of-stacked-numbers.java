import java.util.*;
public class Main {
    static int n, m;
    static Stack<Integer>[][] grid;
    static Stack<Integer> bucket;

    // 동 동남 남 남서 서 서북 북 북동 
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new Stack[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = new Stack<Integer>();
                grid[i][j].push(sc.nextInt());
            }
        }

        int[] moves = new int[m];
        for (int t = 0; t < m; t++) {
            moves[t] = sc.nextInt();
        }

        for (int t = 0; t < m; t++) {
            int numToMove = moves[t];

            int[] numToMoveXY = findNumToMoveXY(numToMove);
            int numToMoveX = numToMoveXY[0];
            int numToMoveY = numToMoveXY[1];

            int[] maxValueXY = findMaxValueXY(numToMoveX, numToMoveY);
            int maxValueX = maxValueXY[0];
            int maxValueY = maxValueXY[1];

            if (maxValueX == -1) {
                while (!bucket.isEmpty()) {
                    grid[numToMoveX][numToMoveY].push(bucket.pop());
                }
                continue;
            }

            while(!bucket.isEmpty()) {
                grid[maxValueX][maxValueY].push(bucket.pop());
            }
        }

        printGrid();
    }

    public static void printGrid() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean check = true;
                while (!grid[i][j].isEmpty()) {
                    check = false;
                    System.out.print(grid[i][j].pop() + " ");
                }
                if (check) System.out.print("None");
                
                System.out.println();
            }
        }
    }

    public static int[] findNumToMoveXY(int num) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                bucket = new Stack<>();
                while (!grid[i][j].isEmpty()) {
                    int pop = grid[i][j].pop();
                    bucket.push(pop);
                    
                    if (pop == num) {
                        return new int[]{i,j};
                    };
                }

                // 뒤져봤는데 없으면 다시 돌려놔야 함.
                while (!bucket.isEmpty()) {
                    grid[i][j].push(bucket.pop());
                }
            }
        }

        return new int[]{-1,-1};
    }

    public static int[] findMaxValueXY(int x, int y) {
        int maxValue = 0;
        int[] maxValueXY = new int[]{-1,-1};

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            Stack<Integer> bucket2 = new Stack<>();

            while (isInBound(nx, ny) && !grid[nx][ny].isEmpty()) {
                int pop = grid[nx][ny].pop();
                bucket2.push(pop);

                if (maxValue < pop) {
                    maxValue = pop;
                    maxValueXY = new int[]{nx, ny};
                }
            }

            while (isInBound(nx, ny) && !bucket2.isEmpty()) {
                grid[nx][ny].push(bucket2.pop());
            }
            
        }

        return maxValueXY;
    }

    public static boolean isInBound(int x, int y) {
        if (x >= 0 && x < n && y >= 0 && y < n) return true;
        return false;
    }
}


// 주변에 아무런 수도 없다면, 즉 maxValue가 0 이라면 움직이지 아니함
// 