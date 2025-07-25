import java.util.Scanner;
public class Main {
    
    static int n;
    static int[][] booms;
    static int[][] grid;
    static int maxCnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        int boomsLength = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                if (grid[i][j] == 1) boomsLength++;
            }
        }
        booms = new int[boomsLength][3];

        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) { 
                    booms[idx][0] = i;
                    booms[idx][1] = j;
                    booms[idx++][2] = 0;
                }
            }
        }

        dfs(0);
        System.out.print(maxCnt);
    }

    public static int boomAndCnt() {
        int[][] boomGrid = new int[n][n];

        for (int i = 0; i < booms.length; i++) {
            int x = booms[i][0];
            int y = booms[i][1];

            if (grid[x][y] == 1) {
                boomGrid[x][y] = 1;
                // 터뜨리려는 칸이 0이어야 함, 넘어가지도 않아야 함
                if (x-1 >= 0 && grid[x-1][y] == 0) boomGrid[x-1][y] = 1;
                if (x-2 >= 0 && grid[x-2][y] == 0) boomGrid[x-2][y] = 1;
                if (x+1 < n && grid[x+1][y] == 0) boomGrid[x+1][y] = 1;
                if (x+2 < n && grid[x+2][y] == 0) boomGrid[x+2][y] = 1;
            } else if (grid[x][y] == 2) {
                boomGrid[x][y] = 2;
                if (x-1 >= 0 && grid[x-1][y] == 0) boomGrid[x-1][y] = 1;
                if (x+1 < n && grid[x+1][y] == 0) boomGrid[x+1][y] = 1;
                if (y+1 < n && grid[x][y+1] == 0) boomGrid[x][y+1] = 1;
                if (y-1 >= 0 && grid[x][y-1] == 0) boomGrid[x][y-1] = 1;
                
            } else if (grid[x][y] == 3) {
                boomGrid[x][y] = 3;
                if (x-1 >= 0 && y-1 >= 0 && grid[x-1][y-1] == 0) boomGrid[x-1][y-1] = 1;
                if (x-1 >= 0 && y+1 < n && grid[x-1][y+1] == 0) boomGrid[x-1][y+1] = 1;
                if (x+1 < n && y-1 >= 0 && grid[x+1][y-1] == 0) boomGrid[x+1][y-1] = 1;
                if (x+1 < n && y+1 < n && grid[x+1][y+1] == 0) boomGrid[x+1][y+1] = 1;
            }
        }

        return cntBooms(boomGrid);
    }

    public static int cntBooms(int[][] paramGrid) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (paramGrid[i][j] != 0) cnt++;
                // System.out.print(paramGrid[i][j] + " ");
            }
            // System.out.println();
        }
            // System.out.println();
        return cnt;
    }

    public static void dfs(int depth) {
        if (depth == booms.length) {
            int boomsCnt = boomAndCnt();

            maxCnt = Math.max(maxCnt, boomsCnt);
            return;
        }


        for (int i = 1; i <= 3; i++) {
            int x = booms[depth][0];
            int y = booms[depth][1];
            grid[x][y] = i;
            // booms[depth][2] = i;
            dfs(depth+1);
        }
    }
}


// 각 위치에다가 폭탄 3개를 순열로 모든 경우의 수에 놓아본다.
// 
// 폭탄이 들어간 위치를 2중 배열로 넣는다.
// depth를 해당 배열의 인덱스를 한다.
// 1씩 증가하며 dfs를 한다.
// booms[depth][2] = i;
// depth가 인덱스를 넘어가는 순간, 종료조건이 된다. 이 때, 터지는 범위를 계산한다.
// 1이면 위아래로 2, 2면 위아래왼오로 1, 