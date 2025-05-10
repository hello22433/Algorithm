import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        // Please write your code here.
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        // 0123 동남서북
        int directionIdx = 1;

        int[][] map = new int[n][m];
        int value = 1;
        int x = -1;
        int y = 0;
        while (value <= n*m) {
            int nx = x + dx[directionIdx];
            int ny = y + dy[directionIdx];

            if (nx<0 || nx>=n || ny<0 || ny<=m || map[nx][ny] != 0) {
                directionIdx = (directionIdx-1+4)%4;
            }

            x = x + dx[directionIdx];
            y = y + dy[directionIdx];
            if (value == 24) break;
            map[x][y] = value;
            value++;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}

// 방향을 아래로 하여 시작한다.
// 시계 반대방향으로 움직인다.
// 방문하였던 곳(숫자가 0이 아닌곳)이나 인덱스를 벗어나면 방향을 바꾼다.
// 최종적으로 움직이는 곳이 인덱스를 벗어나거나 방문하였던 곳이라면 break한다.