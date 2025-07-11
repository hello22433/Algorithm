import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        // Please write your code here.

        int maxSum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                aOuter : for (int a = 1; a < n; a++) {
                    bOuter : for (int b = 1; b < n; b++) {

                        int sum = 0;
                        boolean check = true;
                        int curX = i;
                        int curY = j;

                        for (int c = 1; c <= a; c++) {
                            curX--;
                            curY++;

                            if (!(curX >= 0 && curX < n && curY >= 0 && curY < n)) {
                                check = false;
                                continue bOuter;
                            }
                            sum += grid[curX][curY];

                        }

                        for (int d = 1; d <= b; d++) {
                            curX--;
                            curY--;  

                            if (!(curX >= 0 && curX < n && curY >= 0 && curY < n)) {
                                check = false;
                                continue bOuter;
                            }
                            sum += grid[curX][curY];
                        }

                        for (int c = 1; c <= a; c++) {
                            curX++;
                            curY--;

                            if (!(curX >= 0 && curX < n && curY >= 0 && curY < n)) {
                                check = false;
                                continue bOuter;
                            }
                            sum += grid[curX][curY];
                        }

                        for (int d = 1; d <= b; d++) {
                            curX++;
                            curY++; 

                            if (!(curX >= 0 && curX < n && curY >= 0 && curY < n)) {
                                check = false;
                                continue bOuter;
                            }
                            sum += grid[curX][curY];
                        }

                        if (check) {
                            maxSum = Math.max(maxSum, sum);
                        }
                    }
                }

                
            }
        }

        System.out.print(maxSum);
    }
}


// 문제
// 1~100 NxN
// 기울어진 직사각형들
// 6시에서 시작해서 반시계방향으로 돌아야 함. 각 방향으로 최소 1번은 움직여야 한다.
// 이동중에 격자 밖으로 넘어가서는 안됨
// 적힌 숫자들의 합이 최대가 되어야 함.

// 이해
// 한 점을 잡는다.
// 오른쪽위, 왼쪽위, 왼쪽아래, 오른쪽 아래로 반복문을 만들 것이다.
// a b c d
// a는 1부터 n(대각선의 최대 길이)까지 b도 1부터 n까지 c는 1부터 a까지, d는 1부터 b까지 돌것이다. (마주보는 변의 길이가 같아야 함)
// a는 i-a , j+a
// b는 i-b , j-b
// c는 i+c , j-c
// d는 i+d , j+d

// 돌면서 모든 값을 더한다.
// 각 단계에서 범위를 넘어감과 동시에 false로 바꾸고 break;
// 모든 반복을 다 돌고 true이면 합을 갱신한다.