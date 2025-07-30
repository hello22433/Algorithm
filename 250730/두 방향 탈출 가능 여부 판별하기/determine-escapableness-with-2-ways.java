import java.util.Scanner;
public class Main {
    static int n,m;
    static int[][] grid;
    // 동 남
    static int[] dx = {0,1};
    static int[] dy = {1,0};
    static boolean check = false;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();
        // Please write your code here.

        dfs(0,0);
        
        if (check) System.out.print(1);
        else System.out.print(0);
    }

    public static void dfs(int x, int y) {
        if (check) return;

        if (x == n-1 && y == m-1) {
            check = true;
            return;
        }
        
        for (int i = 0; i < 2; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (canGo(nx, ny))
                dfs(nx, ny);
        }
    } 

    public static boolean inBound(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    public static boolean canGo(int x, int y) {
        if (inBound(x, y) && grid[x][y] == 1) return true;
        else return false;
    }
}


// N x M 
// 