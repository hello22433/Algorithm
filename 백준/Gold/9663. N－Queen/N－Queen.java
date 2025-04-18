
import java.util.*;

public class Main {
    static int[] col; //[행] = 열
    static int N;
    static int result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        result = 0;
        col = new int[N];
        solve(0);
        System.out.println(result);
    }

    private static void solve(int row) {
        if (row == N) {
            result++;
            return;
        }

        for (int i = 0; i < N; i++) {
            col[row] = i;
            if (isPossible(row)) {
                solve(row + 1);
            }
        }
    }

    private static boolean isPossible(int row) {
        for (int i = 0; i < row; i++) {
            if (col[i] == col[row]) {
                return false;
            }
            if (Math.abs(col[i] - col[row]) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }
}



// 0행부터 차례로 체크한다.
// 0행부터 0열마다 체크 -> 이중
// 만약 해당 열에 놓는게 가능하면 다음 행으로 넘어감
// 만약 같은 열에 없고, 대각선에 없다면 해당 열에 놓는게 가능함. (이전 행의 값들을 조사)
//
//