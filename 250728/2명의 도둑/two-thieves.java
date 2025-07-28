import java.util.Scanner;
public class Main {
    static int n,m,c;
    static int maxValue, maxTotalValue = 0;

    static boolean[][] visited;
    static int[][] memorization;
    static int[][] grid;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        c = sc.nextInt();
        grid = new int[n][n];
        memorization = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        // Please write your code here.

        simulateTwoThiefMoves();
        System.out.print(maxTotalValue);
    }


    public static void simulateThiefMove(int x, int y, int depth, int curSumValue, int curWeight) {
        if (curWeight > c) return;

        if (depth == m || y == n) {
            maxValue = Math.max(maxValue, curSumValue);
            return ;
        }

        
        curSumValue += grid[x][y] * grid[x][y];
        curWeight += grid[x][y];
        if (curWeight <= c)
            simulateThiefMove(x, y+1, depth+1, curSumValue, curWeight);
        

        curSumValue -= grid[x][y] * grid[x][y];
        curWeight -= grid[x][y];
        simulateThiefMove(x, y+1, depth+1, curSumValue, curWeight);

    }


    public static void simulateTwoThiefMoves() {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-m+1; j++) {
                maxValue = 0;
                int oneMaxSumValue = 0;

                if (!visited[i][j]) {
                    visited[i][j] = true;
                    simulateThiefMove(i, j, 0, 0, 0);
                    memorization[i][j] = maxValue;
                    oneMaxSumValue = maxValue;
                }
                else oneMaxSumValue = memorization[i][j];
                
                for (int a = i; a < n; a++) {
                    for (int b = 0; b < n-m+1; b++) {
                        if (a == i && b == 0) {
                            b = j + m - 1;
                            continue;
                        }
                        
                        maxValue = 0;
                        int twoMaxSumValue = 0 ;

                        if (!visited[a][b]) {
                            visited[a][b] = true;
                            simulateThiefMove(a, b, 0, 0, 0);
                            memorization[a][b] = maxValue;
                            twoMaxSumValue = maxValue;
                        }
                        else twoMaxSumValue = memorization[a][b];

                        // System.out.print(oneMaxSumValue + " " + twoMaxSumValue);

                        if (maxTotalValue <= oneMaxSumValue + twoMaxSumValue) {
                            maxTotalValue = Math.max(maxTotalValue, oneMaxSumValue + twoMaxSumValue);
                        }
                    }
                }
            }
        }
    }
}

// 두 도둑 -> 각각 하나의 행 -> 그 행 내의 연속한 M개의 열에 있는 물건 훔치기 가능
// 같은 행가능, 선택한 M개의 열이 겹치면 안됨.
// M개가 C를 넘으면 안됨. 넘으면 적절하게 골라서 넘지 않게 가져갈 수 있음.
// 무게 W -> 가치 W^2
// 가치 총 합 최대값!
//
// 하나의 격자씩 탐색한다. (시작점) M개를 탐색한다. 만약 넘어가면 M개 탐색을 그만둔다.
// M개 중에 고를때 조합으로 C이하의 값 중에서 최대값을 고르면 된다. (백트래킹)
// 이를 두개가 겹치지 않도록 해야 한다. 