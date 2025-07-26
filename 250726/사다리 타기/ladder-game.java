import java.util.Scanner;
public class Main {
    static int n, m, minPossibleRowLinesCnt;
    static int[] firstResult;
    static boolean[][] ladders;
    static int[][] laddersXY;
    static int curRowLinesCnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        curRowLinesCnt = m;
        minPossibleRowLinesCnt = m;
        firstResult = new int[n];
        laddersXY = new int[m][2];

        ladders = new boolean[15][n]; // 사람의 번호로 돌았을 때, 한 자리가 비면 안되므로 n-1대신 n

        for(int i = 0; i < m; i++){
            int a = sc.nextInt()-1;
            int b = sc.nextInt()-1;

            ladders[b][a] = true;
            laddersXY[i] = new int[]{b,a};
        }
        // Please write your code here.

        firstResult = simulateRidingLadders();
        dfs(0);
        System.out.print(minPossibleRowLinesCnt);
    }

    public static boolean equalsFirstResult(int[] paramResult) {
        for (int i = 0; i < n; i++) {
            if (firstResult[i] != paramResult[i]) return false;
        }
        return true;
    }

    public static void dfs(int depth) {
        if (depth == m) {
            int[] curReuslt = simulateRidingLadders();
            if (equalsFirstResult(curReuslt)) {
                minPossibleRowLinesCnt = Math.min(minPossibleRowLinesCnt, curRowLinesCnt);
            }
            return;
        }

        int x = laddersXY[depth][0];
        int y = laddersXY[depth][1];

        ladders[x][y] = false;
        curRowLinesCnt--;
        dfs(depth + 1);
        ladders[x][y] = true;
        curRowLinesCnt++;
        dfs(depth + 1); 
    }

    public static void simulateRidingLadder(int startY, int[] bucketResult) {
        int manNum = startY + 1;
        int manY = startY; // n-1까지
        int curY = startY; // n-2까지

        // 0부터 n-1까지 가면서 사다리를 내려간다.
        for (int x = 0; x < 15; x++) {
            if (ladders[x][manY]) {
                manY++;
            } else if (manY-1 >= 0 && ladders[x][manY-1]) {
                manY--;
            } else {
                // 그냥 내려갈거임.
            }
        }

        bucketResult[manY] = manNum;
    }

    public static int[] simulateRidingLadders() {
        int[] bucketResult = new int[n];

        for (int startY = 0; startY < n; startY++) {
            simulateRidingLadder(startY, bucketResult);
        }

        return bucketResult;
    }
}


// 사람 N명, 세로줄 -> 1 ~ N 순서대로 적음 -> 세로줄 사이에 가로줄 M개를 서로 겹치지 않게 긋는다.
// 

// 사다리를 구현한다.
// 돌려보고 횟수를 저장한다.
// 다리수도 저장한다.
// 사다리에서 다리를 하나씩 뺀다. (조합)
// 횟수를 저장한다. 저장한 횟수와 같으면, 현재 다리수를 최소값 갱신한다.
// 