import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];

        // 1부터 100
        int[][] map = new int[101][101];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
            map[x[i]][y[i]] = 1;
        }


        int minPointCnt = Integer.MAX_VALUE;

        for (int i = 0; i <= 100; i+=2) {
            for (int j = 0; j <= 100; j+=2) {
                int xLine = j;
                int yLine = i;

                int pointCnt = 0;
                int maxPointCnt = Integer.MIN_VALUE;

                // 1사분면
                for (int k = 1; k < xLine; k++) {
                    for (int l = 1; l < yLine; l++) {
                        if (map[k][l] == 1) pointCnt++;
                    }
                }
                maxPointCnt = Math.max(pointCnt, maxPointCnt);

                // 2사분면
                pointCnt = 0;
                for (int k = 1; k < xLine; k++) {
                    for (int l = yLine+1; l < 101; l++) {
                        if (map[k][l] == 1) pointCnt++;
                    }
                }
                maxPointCnt = Math.max(pointCnt, maxPointCnt);

                // 3사분면
                pointCnt = 0;
                for (int k = xLine+1; k < 101; k++) {
                    for (int l = 1; l < yLine; l++) {
                        if (map[k][l] == 1) pointCnt++;
                    }
                }
                maxPointCnt = Math.max(pointCnt, maxPointCnt);

                // 4사분면
                pointCnt = 0;
                for (int k = xLine+1; k < 101; k++) {
                    for (int l = yLine+1; l < 101; l++) {
                        if (map[k][l] == 1) pointCnt++;
                    }
                }
                maxPointCnt = Math.max(pointCnt, maxPointCnt);

                minPointCnt = Math.min(minPointCnt, maxPointCnt);
            }
        }
        
        System.out.print(minPointCnt);
    }
}

// 가장 많은 점이 작아야 한다. 
// 가장 왼쪽에 있는 점보다 왼쪽, 오른쪾보다 오른쪽, 위보다 위, 아래보다 아래
// y좌표를 고른다(x축에 평행한 선)(가장 아래부터 위쪽까지), x좌표를 고른다(y축에 평행한 선)(가장 왼쪽부터 오른쪽)
// 1,1 에서 y좌표-1, x좌표-1 까지 센다 (1사분면)
// 0,0부터 시작한다. 
// y좌표가장위쪽x좌표-2 x좌표+1 부터  (2사분면)