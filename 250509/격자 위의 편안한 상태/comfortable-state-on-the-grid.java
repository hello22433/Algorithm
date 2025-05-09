import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int[][] map = new int[N][N];
        for (int i = 0; i < M; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            map[x][y] = 1;

            int oneCount = 0;
            for (int j = 0; j < 4; j++) {
                int nx = x + dx[j];
                int ny = y + dy[j];

                if (nx>=0 && nx<N && ny>=0 && ny<N && map[nx][ny]==1) {
                    oneCount++;
                }
            }
            if (oneCount==3) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}

// 색칠 -> 편안한상태 : 인접한 4개의 칸 중 격자를 벗어나지 않는 칸에 색칠되어 있는 칸이 3개!
//