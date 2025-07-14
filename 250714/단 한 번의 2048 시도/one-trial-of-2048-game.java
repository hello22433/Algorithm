import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] grid = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        char dir = sc.next().charAt(0);

        // 위로 민다
        if (dir == 'U') {
            
            // 각 열부터
            for (int i = 0; i < 4; i++) {
                // 각 행의 위에서부터 탐색
                int[] bucket = new int[4];
                int bucketIdx = 0;
                int firstVal = grid[0][i];
                for (int j = 1; j < 4; j++) {
                    if (grid[j][i] != 0) {
                        if (grid[j][i] != firstVal) {
                            if (firstVal != 0) bucket[bucketIdx++] = firstVal;
                            firstVal = grid[j][i];
                        } else {
                            bucket[bucketIdx++] = firstVal*2;
                            firstVal = 0;
                        }
                    }
                }
                if (firstVal != 0) bucket[bucketIdx++] = firstVal;

                for (int j = 1; j < 4; j++) {
                    grid[j][i] = bucket[j];
                }
            }
            
        } else if (dir == 'R') {

            // 각 행부터
            for (int i = 0; i < 4; i++) {
                // 각 열의 마지막(오른쪽)에서부터 탐색
                int[] bucket = new int[4];
                int bucketIdx = 0;
                int firstVal = grid[i][3];
                for (int j = 2; j >= 0; j--) {
                    if (grid[i][j] != 0) {
                        if (grid[i][j] != firstVal) {
                            if (firstVal != 0) bucket[bucketIdx++] = firstVal;
                            firstVal = grid[i][j];
                        } else {
                            bucket[bucketIdx++] = firstVal*2;
                            firstVal = 0;
                        }
                    }
                }
                if (firstVal != 0) bucket[bucketIdx++] = firstVal;


                for (int j = 3; j >= 0; j--) {
                    grid[i][j] = bucket[3-j];
                }
            }

        } else if (dir == 'D') {

            // 각 열부터
            for (int i = 0; i < 4; i++) {
                // 각 행의 아래에서부터 탐색
                int[] bucket = new int[4];
                int bucketIdx = 0;
                int firstVal = grid[3][i];
                for (int j = 2; j >= 0; j--) {
                    if (grid[j][i] != 0) {
                        if (grid[j][i] != firstVal) {
                            if (firstVal != 0) bucket[bucketIdx++] = firstVal;
                            firstVal = grid[j][i];
                        } else {
                            bucket[bucketIdx++] = firstVal*2;
                            firstVal = 0;
                        }
                    }
                }
                if (firstVal != 0) bucket[bucketIdx++] = firstVal;

                for (int j = 3; j >= 0; j--) {
                    grid[j][i] = bucket[3-j];
                }
            }

        } else if (dir == 'L') {

            // 각 행부터
            for (int i = 0; i < 4; i++) {
                // 각 열의 처음(왼쪽)에서부터 탐색
                int[] bucket = new int[4];
                int bucketIdx = 0;
                int firstVal = grid[i][0];
                for (int j = 1; j < 4; j++) {
                    if (grid[i][j] != 0) {
                        if (grid[i][j] != firstVal) {
                            if (firstVal != 0) bucket[bucketIdx++] = firstVal;
                            firstVal = grid[i][j];
                        } else {
                            bucket[bucketIdx++] = firstVal*2;
                            firstVal = 0;
                        }
                    }
                }
                if (firstVal != 0) bucket[bucketIdx++] = firstVal;


                for (int j = 0; j < 4; j++) {
                    grid[i][j] = bucket[j];
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}

// 밀리게 되는 방향(ex. L)의 반대에서부터 탐색을 한다.(각행을 각열의 오른쪽에서부터 탐색한다)
// 똑같은 쌍을 찾는다.
// 첫번째 값 지정 -> 0이 아닌 첫번째값과 다른 값이 나오면, bucket에 앞에서부터 첫번째값을 넣고, 다른 값이 나온 해당 값으로 갱신.  
//             -> 0이 아닌 같은 값이 나오면 하나의 값을 2배해서, bucket에 앞에서부터 넣는다. -> 0으로 첫번째 값을 변경
// 현재 첫번째 값이 0이 아니라면(마지막에 합쳐지지 않았다면) bucket에 넣는다.
// 