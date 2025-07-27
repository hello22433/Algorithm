import java.util.Scanner;

public class Main {
    static int n, m, c;
    static int[][] grid;
    static int[][] maxValueGrid;
    static int maxTotalValue = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();  // 격자 크기
        m = sc.nextInt();  // 도둑이 훔칠 수 있는 연속한 칸 수
        c = sc.nextInt();  // 도둑이 들 수 있는 최대 무게

        grid = new int[n][n];
        maxValueGrid = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        // 각 시작 위치 (i,j)에서 m개 아이템의 조합 중 최대 가치 미리 계산
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n - m; j++) {
                int[] items = new int[m];
                for (int k = 0; k < m; k++) {
                    items[k] = grid[i][j + k];
                }
                maxValueGrid[i][j] = getMaxValue(items);
            }
        }

        // 두 도둑의 위치를 조합하여 최대값 계산
        for (int i1 = 0; i1 < n; i1++) {
            for (int j1 = 0; j1 <= n - m; j1++) {
                for (int i2 = i1; i2 < n; i2++) {
                    int jStart = (i1 == i2) ? j1 + m : 0;
                    for (int j2 = jStart; j2 <= n - m; j2++) {
                        int total = maxValueGrid[i1][j1] + maxValueGrid[i2][j2];
                        maxTotalValue = Math.max(maxTotalValue, total);
                    }
                }
            }
        }

        System.out.println(maxTotalValue);
    }

    // 부분집합을 통해 최대 가치 계산 (무게 합 <= c)
    public static int getMaxValue(int[] items) {
        int maxVal = 0;
        int len = items.length;

        for (int i = 0; i < (1 << len); i++) {
            int weightSum = 0;
            int valueSum = 0;
            for (int j = 0; j < len; j++) {
                if ((i & (1 << j)) != 0) {
                    weightSum += items[j];
                    valueSum += items[j] * items[j];
                }
            }
            if (weightSum <= c) {
                maxVal = Math.max(maxVal, valueSum);
            }
        }
        return maxVal;
    }
}


// import java.util.Scanner;
// public class Main {
//     static int n,m,c;
//     static int oneWeightSum, twoWeightSum;
//     static int maxTotalValue, oneMaxSumValue, twoMaxSumValue = 0;

//     static int[][] memorization;
//     static int[][] grid;
    
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         n = sc.nextInt();
//         m = sc.nextInt();
//         c = sc.nextInt();
//         grid = new int[n][n];
//         memorization = new int[n][n];
//         for (int i = 0; i < n; i++)
//             for (int j = 0; j < n; j++)
//                 grid[i][j] = sc.nextInt();
//         // Please write your code here.

//         simulateTwoThiefMoves();
//         System.out.print(maxTotalValue);
//     }


//     public static void simulateThiefMove(int num, int x, int y, int depth, int curSumValue) {
//         if (depth == m || y == n) {
//             if (num == 1 && oneWeightSum <= c) {
//                 if (oneMaxSumValue <= curSumValue) {
//                     oneMaxSumValue = Math.max(oneMaxSumValue, curSumValue);
//                 }
//             }
//             if (num == 2 && twoWeightSum <= c) {
//                 if (twoMaxSumValue <= curSumValue) {
//                     twoMaxSumValue = Math.max(twoMaxSumValue, curSumValue);
//                 }
//             }
//             return;
//         }

        
//         if (num == 1) {
//             oneWeightSum += grid[x][y];
//             curSumValue += (int) Math.pow(grid[x][y], 2);
//         }
//         if (num == 2) { 
//             twoWeightSum += grid[x][y];
//             curSumValue += (int) Math.pow(grid[x][y], 2);
//         }
//         simulateThiefMove(num, x, y+1, depth+1, curSumValue);
//         if (num == 1) {
//             oneWeightSum -= grid[x][y];
//             curSumValue -= (int) Math.pow(grid[x][y], 2);
//         }
//         if (num == 2) { 
//             twoWeightSum -= grid[x][y];
//             curSumValue -= (int) Math.pow(grid[x][y], 2);
//         }
//         simulateThiefMove(num, x, y+1, depth+1, curSumValue);

//     }


//     public static void simulateTwoThiefMoves() {

//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < n-m+1; j++) {
//                 oneWeightSum = 0;
//                 oneMaxSumValue = 0;

//                 if (memorization[i][j] == 0) {
//                     simulateThiefMove(1, i, j, 0, 0);
//                     memorization[i][j] = oneMaxSumValue;
//                 }
//                 else oneMaxSumValue = memorization[i][j];
                
//                 for (int a = i; a < n; a++) {
//                     for (int b = 0; b < n-m+1; b++) {
//                         if (a == i) {
//                             b = j + m;
//                             continue;
//                         }
//                         twoWeightSum = 0;
//                         twoMaxSumValue = 0;

//                         if (memorization[a][b] == 0) {
//                             simulateThiefMove(2, a, b, 0, 0);
//                             memorization[a][b] = twoMaxSumValue;
//                         }
//                         else twoMaxSumValue = memorization[a][b];

//                         // System.out.print(oneMaxSumValue + " " + twoMaxSumValue);

//                         if (maxTotalValue <= oneMaxSumValue + twoMaxSumValue) {
//                             maxTotalValue = Math.max(maxTotalValue, oneMaxSumValue + twoMaxSumValue);
//                         }
//                     }
//                 }
//             }
//         }
//     }
// }

// // 두 도둑 -> 각각 하나의 행 -> 그 행 내의 연속한 M개의 열에 있는 물건 훔치기 가능
// // 같은 행가능, 선택한 M개의 열이 겹치면 안됨.
// // M개가 C를 넘으면 안됨. 넘으면 적절하게 골라서 넘지 않게 가져갈 수 있음.
// // 무게 W -> 가치 W^2
// // 가치 총 합 최대값!
// //
// // 하나의 격자씩 탐색한다. (시작점) M개를 탐색한다. 만약 넘어가면 M개 탐색을 그만둔다.
// // M개 중에 고를때 조합으로 C이하의 값 중에서 최대값을 고르면 된다. (백트래킹)
// // 이를 두개가 겹치지 않도록 해야 한다. 