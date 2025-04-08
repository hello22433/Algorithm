

import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();

        int[][] matrixA = new int[N][M];
        int[][] matrixB = new int[N][M];
        for (int i = 0; i < N; i++) {
            String a = sc.nextLine();
            for (int j = 0; j < M; j++) {
                matrixA[i][j] = Integer.parseInt(String.valueOf(a.charAt(j)));
            }
        }
        for (int i = 0; i < N; i++) {
            String a = sc.nextLine();
            for (int j = 0; j < M; j++) {
                matrixB[i][j] = Integer.parseInt(String.valueOf(a.charAt(j)));
            }
        }


        int count = 0;
        for (int t = 0; t < 2; t++) {
            for (int i = 0; i < N-2; i++) {
                for (int j = 0; j < M-2; j++) {
                    if (matrixA[i][j] != matrixB[i][j]) {
                        ++count;
                        for (int a = i; a <= i+2; a++) {
                            for (int b = j; b <= j+2; b++) {
                                if (matrixA[a][b] == 1) {
                                    matrixA[a][b] = 0;
                                } else {
                                    matrixA[a][b] = 1;
                                }
                            }
                        }


                        boolean check = false;
                        for (int a = 0; a < N; a++) {
                            for (int b = 0; b < M; b++) {
                                if (matrixA[a][b] != matrixB[a][b]) {
                                    check = true;
                                    break;
                                }
                            }
                            if (check) {
                                break;
                            }
                        }
                        if (!check) {
                            System.out.print(count);
                            return;
                        }
                    }
                }
            }
        }


        boolean check = false;
        for (int a = 0; a < N; a++) {
            for (int b = 0; b < M; b++) {
                if (matrixA[a][b] != matrixB[a][b]) {
                    check = true;
                    break;
                }
            }
            if (check) {
                break;
            }
        }
        if (!check) {
            System.out.print(count);
            return;
        }

        System.out.print(-1);



    }
}

// 3x3만 가능. 이 미만, 초과는 불가능
// 1인부분은 어쨌든 바꿔야 한다.
// 행렬을 만든다.
// 끝에서 -2 뺸만큼까지만 탐색한다.
// 탐색한 곳이 만약 B의 동일 부분과 같다면 그 점을 시작점으로 하여 3x3부분을 행렬을 변환한다.
// 각 반복 후에는 count+=1, 탐색을 시작하고 같으면 count를 출력한다.
// 2번 반복하면 원래와 똑같아짐.
// 2번 반복후에 동시에 탐색을 시작하고 다른 부분이 있으면 -1을 출력한다.
