import java.util.Scanner;

public class Main {
    static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        arr = new int[19][19];
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        // Please write your code here.
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19-4; j++) {
                // 검1 흰2 노알0
                int color = arr[i][j];
                if (color==0) continue;

                // 가로(세로줄) 탐색 j 
                for (int k = 1; k < 5; k++) {
                    if (arr[i][j+k] != color) break;
                    if (k==4) {
                        // 1-based로 바꾸어주어야 함
                        endGame(color, i+1, j+2+1);
                        return;
                    }
                }
            }
        }

        for (int i = 0; i < 19-4; i++) {
            for (int j = 0; j < 19; j++) {
                // 검1 흰2 노알0
                int color = arr[i][j];
                if (color==0) continue;

                // 세로(가로줄) 탐색 i
                for (int k = 1; k < 5; k++) {
                    if (arr[i+k][j] != color) break;
                    if (k==4) {
                        endGame(color, i+2+1, j+1);
                        return;
                    }
                }
            }
        }

        // 가로줄 세로줄
        for (int i = 0; i < 19-4; i++) {
            for (int j = 0; j < 19-4; j++) {
                // 검1 흰2 노알0
                int color = arr[i][j];
                if (color==0) continue;

                // 대각선 오른쪽 아래(가로줄, 세로줄) 탐색 i, j
                for (int k = 1; k < 5; k++) {
                    if (arr[i+k][j+k] != color) break;
                    if (k==4) {
                        endGame(color, i+2+1, j+2+1);
                        return;
                    }
                }
            }
        }

        for (int i = 0; i < 19-4; i++) {
            for (int j = 18; j >= 4; j--) {
                int color = arr[i][j];
                if (color==0) continue;

                // 대각선 왼쪽 아래(가로줄, 세로줄) 탐색 i, j
                for (int k = 1; k < 5; k++) {
                    if (arr[i+k][j-k] != color) break;
                    if (k==4) {
                        endGame(color, i+2+1, j-2+1);
                        return;
                    }
                }
            }
        }

        System.out.print(0);
        
    }

    public static void endGame(int color, int resultI, int resultJ) {
        if (color == 1) {
            System.out.println(1);
            System.out.print(resultI + " " + resultJ);
        } else {
            System.out.println(2);
            System.out.print(resultI + " " + resultJ);
        }
    }
}

// 모든 바둑판을 가로와 세로를 n-4까지 돈다 (가로 세로로 4개를 남김으로써 총 5개를 탐색)
// 가로 + 4까지j, 세로 + 4까지i, 대각선 + 4까지i/j 탐색한다. 0부터 <5
// 만약 색이 같지 않으면 break;
// 만약 오목이면 (마지막까지 탐색이 간다면) 가로면 i는 그대로 j
// 1 ~ 5
// 0 ~ 4
// +1하고 /한 값이 중간 인덱스