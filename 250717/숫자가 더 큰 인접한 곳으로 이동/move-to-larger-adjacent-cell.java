import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        int[][] grid = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        // Please write your code here.

        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        int x = r;
        int y = c;
        

        outer: while (true) {
            
            int val = grid[x][y];
            System.out.print(val + " ");
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 1 && nx <= n && ny >= 1 && ny <= n && grid[nx][ny] > val) {
                    x = nx;
                    y = ny;
                    continue outer;
                }
            }

            break;
        }
    }
}