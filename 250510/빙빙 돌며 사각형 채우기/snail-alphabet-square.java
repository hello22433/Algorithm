import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        // Please write your code here.
        int charValue = 65;
        int count = 1;
        // 동남서북 0123
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        int directionIdx = 0;
        char[][] map = new char[n][m];

        int x = 0;
        int y = -1;
        
        while (count <= n*m) {
            int nx = x + dx[directionIdx];
            int ny = y + dy[directionIdx];

            if (nx<0 || nx>=n || ny<0 || ny>=m || map[nx][ny]!=0) {
                directionIdx = (directionIdx + 1) % 4;
            }

            x = x + dx[directionIdx];
            y = y + dy[directionIdx];

            map[x][y] = (char) charValue;

            charValue++;
            count++;
            if (charValue > 90) {
                charValue = 65;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}

// 