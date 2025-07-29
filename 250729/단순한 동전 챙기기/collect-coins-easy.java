import java.util.*;

public class Main {
    static int n;
    static int[] sXY, eXY;
    static char[][] grid;
    // static int[][] numbersXY = new int[10][3];
    static List<int[]> existedNumber = new ArrayList<>();
    static boolean[] visited;
    static int[][] choiceNumsXY = new int[4][2];

    static int minMovesCnt = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new char[n][n];
        
        for (int i = 0; i < n; i++) {
            char[] bucket = sc.next().toCharArray();

            for (int j = 0; j < n; j++) {
                grid[i][j] = bucket[j];

                if (bucket[j] == 'S') sXY = new int[]{i,j};
                else if (bucket[j] == 'E') eXY = new int[]{i,j};
                else if (bucket[j] != '.') {
                    // System.out.println(Character.getNumericValue(bucket[j]));

                    // numbersXY[Character.getNumericValue(bucket[j])][0] = i;
                    // numbersXY[Character.getNumericValue(bucket[j])][1] = j;
                    // numbersXY[Character.getNumericValue(bucket[j])][2] = bucket[j];

                    existedNumber.add(new int[]{i, j, bucket[j]});
                }
            }
        }

        choiceNumsXY[3] = eXY;
        
        visited = new boolean[existedNumber.size()];
        Collections.sort(existedNumber, (a,b) -> {
            return a[2] - b[2];
        });

        dfs(0, 0);

        if (minMovesCnt == Integer.MAX_VALUE) {
            System.out.print(-1);
        } else {
            System.out.print(minMovesCnt);
        }
    }

    public static void dfs(int startIdx, int depth) {
        if (depth == 3) {
            // 정하고 움직이고 , 정하고 움직이고 반복..
            int movesSum = 0;

            int[] curXY = sXY;
            int curX = curXY[0];
            int curY = curXY[1];

            for (int i = 0; i < 4; i++) {
                int nx = choiceNumsXY[i][0];
                int ny = choiceNumsXY[i][1];

                movesSum += Math.abs(nx-curX) + Math.abs(ny-curY);

                curX = nx;
                curY = ny;
            }

            minMovesCnt = Math.min(minMovesCnt, movesSum);
            return;
        }

        for (int i = startIdx; i < existedNumber.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                choiceNumsXY[depth] = existedNumber.get(i);
                dfs(i+1, depth+1);
                visited[i] = false;
            }
        }
    }
}


// 1~9 동전번호. 도달해야 얻을 수 있음. 각 위치에 하나씩만. 
// N x N
// , S E
// 
// 시작점 ->  최소 3개 동전 수집 -> 도착점 도달
// 번호 증가 순서대로만 수집.
// 꼭 수집하지 않아도 됨, 같은 위치 2번이상 OK
// 
// S 숫자 E .
// 배열에 넣는다.
// 숫자 3개를 번갈아가며 고른다. 
// 고른 숫자의 좌표를 찾아서 이동횟수를 구한다.
// 이동횟수 = 현재좌표에서 x와 y의 좌표를 뺀다.
// 
//