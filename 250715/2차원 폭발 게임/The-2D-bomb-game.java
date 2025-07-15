import java.util.Scanner;

public class Main {
    static int n,m,k;
    static int[][] grid;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        // Please write your code here.

        for (int t = 0; t < k; t++) {
            removeChainBombs();
            pullDownBombs();
            rotateBoard();
            pullDownBombs();
        }

        removeChainBombs();
        int remainBombs = countRemainBombs();
        System.out.print(remainBombs);
    }

    public static int countRemainBombs() {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) cnt++;
            }
        }
        return cnt;
    }

    public static void rotateBoard() {
        // 단순히 오른쪽으로 정렬하고, 새로운 2차원 배열에 마지막행을 첫번째열로, 마지막열을 마지막 행으로 바꾸면 된다.
        // 다만, 마지막열의 첫번쨰행이 마지막행의 마지막열이 된다. 
        // 순회할떄, 행과 열을 바꾼다. 
        // 애초에 순회할떄, 열을 순회하고, 행을 순회하면 즉, 방향을 바꿔서 순회하면 방향을 바꾼게 되는게 아닐까?
        pullRightBombs();

        // 차례로 읽어나간다 -> 
        int[][] newGrid = new int[n][n];
        int newGridIIdx = 0;
        int newGridJIdx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = n-1; j >= 0; j--) {
                newGrid[newGridIIdx][newGridJIdx++] = grid[j][i];
            }
            newGridIIdx++;
            newGridJIdx = 0;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = newGrid[i][j];
            }
        }
    }

    public static void pullRightBombs() {
        // 행을 순회한다.
        for (int i = 0; i < n; i++) {
            // 열을 순회한다.
            // 0열부터 탐색하여 0이 아닌 수만 bucket에 넣는다.
            int[] bucket = new int[n];
            int bucketIdx = 0;
            for (int j = n-1; j >= 0; j--) {
                if (grid[i][j] != 0) {
                    bucket[bucketIdx++] = grid[i][j];
                }
            }

            // 이후 오른쪽에서부터 채워야 하므로, bucket의 마지막 인덱스부터 원래 열에 넣는다.
            for (int j = n-1; j >= 0; j--) {
                grid[i][j] = bucket[n-1-j];
            }
        }
    }

    public static void pullDownBombs() {
        // 열을 순회한다.
        for (int i = 0; i < n; i++) {
            // 행을 순회한다.
            // 0행부터 탐색하여 0이 아닌 수만 bucket에 넣는다.
            // 이후 아래에서부터 채워야 하므로, bucket의 마지막 인덱스부터 원래 열에 넣는다.
            int[] bucket = new int[n];
            int bucketIdx = 0;
            for (int j = n-1; j >= 0; j--) {
                if (grid[j][i] != 0) {
                    bucket[bucketIdx++] = grid[j][i];
                }
            }

            for (int j = n-1; j >= 0; j--) {
                grid[j][i] = bucket[n-1-j];
            }
        }
    }

    public static void removeChainBombs() {
        // 열을 순회한다.
        for (int i = 0; i < n; i++) {
            
            // 행마다 연속되는 폭탄이 있는지 찾는다.
            // 처음 수를 지정하고, 같은 폭탄이 나올 때마다 카운트한다. (초기값 1) , 동시에 시작 인덱스도 저장한다.
            int firstVal = grid[0][i];
            int cnt = 1;
            int startIdx = 0;
            // 어차피 0으로 만들 것이기에 처음수가 0이어도 상관없음.
            // 처음저장한 수와 다른 수가 나왔는데 카운트가 m이상이면 0으로 만들 것이다.(if문으로 실행)
            // 아니라면 그냥 넘어가면 된다. 
            for (int j = 1; j < n; j++) {
                if (grid[j][i] != firstVal) {
                    if (cnt >= m) {
                        for (int a = startIdx; a < j; a++) {
                            grid[a][i] = 0;
                        }
                    }

                    firstVal = grid[j][i];
                    cnt = 1;
                    startIdx = j;
                } else {
                    cnt++;
                }
            }

            // 반복문이 모두 끝나고 카운트가 m이상이면 startIdx부터 n-1까지 모두 0으로 만든다.
            if (cnt >= m) {
                for (int a = startIdx; a < n; a++) {
                    grid[a][i] = 0;
                }
            }
        }
    }
}

// K번 : (탐색 -> 터뜨림) -> 내림 -> 돌림 -> 내림 -> (탐색 -> 터뜨림) -> ...
// 터뜨림 -> 남은 폭탄(0이 아닌 격자) 카운트
// 출력