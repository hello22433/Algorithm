import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        int m1 = sc.nextInt();
        int m2 = sc.nextInt();
        int m3 = sc.nextInt();
        int m4 = sc.nextInt();
        int dir = sc.nextInt();
        // Please write your code here.


        int curX = r-1;
        int curY = c-1;
        if (dir == 0) { // 반시계
            List<Integer> list = new ArrayList<>();
            for (int t = 0; t < m1; t++) {
                list.add(grid[curX][curY]);
                curX--;
                curY++;
            }
            for (int t = 0; t < m1; t++) {
                list.add(grid[curX][curY]);
                curX--;
                curY++;
            }
            for (int t = 0; t < m1; t++) {
                list.add(grid[curX][curY]);
                curX--;
                curY++;
            }

        } else { // 시계

        }
    }
}

// 마주보는 변의 크기인
// m1과 m3의 절대값은 같다
// m2과 m4의 절대값은 같다

// 이동할 위치에 현재 위치의 값을 갱신한다.
// 현재 위치를 이동할 위치로 갱신한다.
// (반시계)
// m1번 만큼, i-1 j+1을 해서 이동해야 한다.
// m2번 만큼, i-1 j-1을 해서 이동해야 한다.
// m3번 만큼, i+1 j-1을 해서 이동해야 한다.
// m4번 만큼, i+1 j+1을 해서 이동해야 한다.

// (시계)
// m4번 만큼, i-1 j-1을 해서 이동해야 한다.
// m3번 만큼, i-1 j+1을 해서 이동해야 한다.
// m2번 만큼, i+1 j+1을 해서 이동해야 한다.
// m1번 만큼, i+1 j-1을 해서 이동해야 한다.
// 

// 첫번째 값은 미리 더하지 않는다. 도착한 값을 더하는 로직을 짤 것이기 때문에, 마지막 이동에서 출발점으로 돌아와 더할 것이기 때문
// 