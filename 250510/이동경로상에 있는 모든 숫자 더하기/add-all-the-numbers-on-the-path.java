import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        String commands = sc.next();
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        // Please write your code here.
        int x = (n-1)/2;
        int y = (n-1)/2;
        // 동남서북
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        int directionIdx = 3;
        int resultSum = board[x][y];

        for (int i = 0; i < commands.length(); i++) {
            char command = commands.charAt(i);

            if (command == 'F') {
                int nx = x + dx[directionIdx];
                int ny = y + dy[directionIdx];

                if (nx<0 || nx>=n || ny<0 || ny>=n) {
                    continue;
                }

                x = nx;
                y = ny;
                resultSum += board[x][y];
            } else if (command == 'R') {
                directionIdx = (directionIdx + 1) % 4;
            } else {
                directionIdx = (directionIdx - 1 + 4) % 4;
            }
        }

        System.out.print(resultSum);
    }
}

// 시작위치를 포함하여 해당칸에 적혀있는 수 누적합
// 격자 범위 벗어나는 명령은 무시
// 가운데에서 북쪽으로 향한 상태에서 시작
// 