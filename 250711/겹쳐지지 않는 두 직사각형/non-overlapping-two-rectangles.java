import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int maxValueSum = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = i; k < n; k++) {
                    for (int l = j; l < n; l++) {

                        // 첫번째 직사각형 넓이
                        int firstSquareValueSum = 0;
                        for (int a = i; a <= k; a++) {
                            for (int b = j; b <= l; b++) {
                                firstSquareValueSum += grid[a][b];
                            }
                        }

                        int valueSum = firstSquareValueSum;

                        // 두번째 직사각형의 두 점
                        for (int a = 0; a < n; a++) {
                            for (int b = 0; b < n; b++) {
                                for (int c = a; c < n; c++) {
                                    for (int d = b; d < n; d++) {
                                        if (a <= k && b <= l) continue;
                                        
                                        // 두번째 직사각형 넓이
                                        int secondSquareValueSum = 0;
                                        for (int u = a; u <= c; u++) {
                                            for (int v = b; v <= d; v++) {
                                                secondSquareValueSum += grid[u][v];
                                            }
                                        }

                                        valueSum += secondSquareValueSum;

                                        maxValueSum = Math.max(maxValueSum, valueSum);

                                        valueSum = firstSquareValueSum;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.print(maxValueSum);

        
    }
}


// 문제
// N x M , 각 위치에 정수 값이 하나씩 !
// 겹치지 않는 두 직사각형 만들기!
// 두 직사각형의 숫자 총 합을 최대화하라.
// 변들은 격자 판에 평행해야 한다.
// 꼭 2개의 직사각형
// 

// 이해
// 두 점을 잡는다. 
// 각 점에 대해서 직사각형을 만든다. 
// how? 행이 늘어나는 것이 있고, 열이 늘어나는 것이 있다.
// 

// no! 네 점을 잡는다
// 각점은 순서대로, 첫번째, 두번째 직사각형의 왼쪽상단꼭지점, 오른쪽 하단꼭지점이 된다. 