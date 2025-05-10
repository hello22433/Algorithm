import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        int value = n*n;
        int[][] map = new int[n][n];
        // 동남서북 0123
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int directionIdx = 2;
        
        int x = n-1;
        int y = n-1+1;

        while (value >= 1) {
            int nx = x + dx[directionIdx];
            int ny = y + dy[directionIdx];

            if (nx<0 || nx>=n || ny<0 || ny>=n || map[nx][ny]!=0) {
                directionIdx = (directionIdx + 1) % 4;
            }
            
            x = x + dx[directionIdx];
            y = y + dy[directionIdx];

            map[x][y] = value;

            value--;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}


// (N - 1) / 2 => 가운데 인덱스
// 서 북 동 남
// 