import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int cnt = 0;
        // 열
        String[][] arr = new String[n][n];
        for (int i = 0; i < n; i++) {
            for (int j  = 0 ; j < n; j++) {
                arr[i][j] = "  ";
            }
        }


        for (int i = 0; i < n; i++) {
            if ((i+1)%2 != 0) {
                arr[0][i] = "* ";
            } else {
                for (int j = 0; j <= i; j++) {
                    arr[j][i] = "* ";
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j]);
            }
                System.out.println();
        }

    }
}


// n이 열의 갯수
// 홀수일때는 행이 1개
// 짝수일때는 행이 열의 번째만큼 출력된다.

// n개를 출력한다.
// 2번째 줄에 