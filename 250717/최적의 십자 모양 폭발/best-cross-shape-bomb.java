import java.util.Scanner;

public class Main {
    static int n;
    static int[][] grid;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
                
        // Please write your code here.
        int maxCnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int cnt = 0;
                int[][] newMap = exploreBomb(i, j);
                cnt += cntPairRow(newMap);
                cnt += cntPairColumn(newMap);
                maxCnt = Math.max(maxCnt, cnt);
            }
        }

        System.out.print(maxCnt);
    }

    public static int cntPairColumn(int[][] map) {
        int cnt = 0;

        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == map[i+1][j] && map[i][j] != 0) cnt++;
            }
        }

        return cnt;
    }

    public static int cntPairRow(int[][] map) {
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-1; j++) {
                if (map[i][j] == map[i][j+1] && map[i][j] != 0) cnt++;
            }
        }

        return cnt;
    }

    public static int[][] exploreBomb(int r, int c) {
        int[][] newMap = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                newMap[i][j] = grid[i][j];
            }
        }

        int boomSize = newMap[r][c];
        newMap[r][c] = 0;

        // 위 오 아 왼
        for (int i = 1; i < boomSize; i++) {
            if (r-i >= 0)
                newMap[r-i][c] = 0;
        }
        for (int i = 1; i < boomSize; i++) {
            if (c+i < n)
                newMap[r][c+i] = 0;
        }
        for (int i = 1; i < boomSize; i++) {
            if (r+i < n)
                newMap[r+i][c] = 0;
        }
        for (int i = 1; i < boomSize; i++) {
            if (c-i >= 0)
                newMap[r][c-i] = 0;
        }

        pullDownMap(newMap);
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < n; j++) {
        //         System.out.print(newMap[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        return newMap;
    }

    public static void pullDownMap(int[][] map) {
        // 열 순회
        for (int i = 0; i < n; i++) {
            int[] bucket = new int[n];
            int bucketIdx = 0;

            for (int j = n-1; j>= 0; j--) {
                if (map[j][i] != 0) bucket[bucketIdx++] = map[j][i];
            }
            
            for (int j = n-1; j>= 0; j--) {
                map[j][i] = bucket[n-1-j];
            }
        }
    }
}

// N x N 1~100 
// grid[r][c] - 1 만큼 상하좌우로 뻗어나가 터짐 
// 중력으로 밑으로 내려감
// 최적 십자 모양 폭발 : 가로, 세로로 2개씩 숫자 쌍이 최대가 되어야 함.
// 연속으로 되어 있으면 중복해서 사용 가능하다고 가정.
// 안 터뜨린게 최대라 해도 무조건 1개는 터뜨려야 함.

// 폭발 함수
// 클론 한 후, 새로운 2차원 배열을 반환

// 체크함수. 세로 / 가로