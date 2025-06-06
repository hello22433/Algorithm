import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 행열크기
        int n = sc.nextInt();

        int[][] arr = new int[n][n];

        int num = 1;

        // 열
        for (int i = n-1; i >= 0; i--) {

            // 행
            // n이 짝수일때, i가 홀수이면 행을 거꾸로 타고 올로간다. (오른쪽 아래에서 시작해야 하기 때문)
            if (n % 2 == 0) {
                if (i % 2 != 0) {
                    for (int j = n-1; j >= 0; j--) {
                        arr[j][i] = num++;
                    }
                } else {
                    for (int j = 0; j < n; j++) {
                        arr[j][i] = num++;
                    }
                }
            } else {
                if (i % 2 == 0) {
                    for (int j = n-1; j >= 0; j--) {
                        arr[j][i] = num++;
                    }
                } else {
                    for (int j = 0; j < n; j++) {
                        arr[j][i] = num++;
                    }
                }
            }
        }

        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}

// 1열씩 증가할 것이고
// 시작은 1행에서 무조건 할 것이고
// 1행이 늘어나고 1열이 줄어든다.