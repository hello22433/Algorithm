import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        char[][] grid = new char[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                grid[i][j] = sc.next().charAt(0);
            }
        }
        // Please write your code here.
        int count = 0;
        for (int i = 1; i < R-2; i++) {
            for (int j = 1; j < C-2; j++) {
                if (grid[0][0] == grid[i][j]) continue;
                if (i == R-1 && j == C-1) continue;
                for (int k = i+1; k < R-1; k++) {
                    for (int l = j+1; l < C-1; l++) {
                        if (grid[i][j] == grid[k][l]) continue;
                        if (k == R-1 && l == C-1) continue;
                        if (grid[k][l] == grid[R-1][C-1]) continue;
                        count++;
                    }
                }
            }
        }
        System.out.print(count);
    }
}

// 점프 이후 색이 달라야만 한다
// 한칸 이상 오른쪽and아래쪽
// 시작, 도착 지점을 제외하고 점프로 도달한 위치가 2곳이어야 한다.
// 
// 현재 컬러와 이동하는 곳의 컬러가 다르면 이동
// 지금 행,열 보다 최소한 하나는 큰 곳으로 이동해야 함.
// 초기 : (0,0) / 도착 : (R-1, W-1)
// 조건을 만족하는 이동을 두 번 하면 카운트한다.
// 
