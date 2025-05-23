import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] line = new int[N+1];
        int[][] segments = new int[M][2];
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (a <= b) {
                segments[i][0] = a;
                segments[i][1] = b;
            } else {
                segments[i][0] = b;
                segments[i][1] = a;
            }
        }

        int maxCnt = Integer.MIN_VALUE;
        for (int x = 1; x <= N; x++) {
            for (int y = 1; y <= N; y++) {
                
                int checkEqualCnt = 0;
                for (int i = 0; i < M; i++) {
                    if (segments[i][0] == x && segments[i][1] == y) {
                        checkEqualCnt++;
                    }
                }

                maxCnt = Math.max(maxCnt, checkEqualCnt);
            }
        }
        System.out.print(maxCnt);
    }
}

// 이차원 배열 
// 고려대학교 컴퓨터과학과