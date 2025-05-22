import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inp1 = sc.next();
        String inp2 = sc.next();
        String inp3 = sc.next();
        String[] inp = {inp1, inp2, inp3};
        // Please write your code here.

        int cnt = 0;

        // 가로
        for (int i = 0; i < 3; i++) {

            // 기준을 잡는다.
            for (int j = 0; j < 3; j++) {
                char base = inp[i].charAt(j);

                // 기준을 잡고 돌린다.
                int diffCnt = 0;
                for (int k = 0; k < 3; k++) {
                    if (inp[i].charAt(k) != base) {
                        diffCnt++;
                    }
                }
                if (diffCnt == 1) {
                    cnt++;
                    break;
                }

            }
        }

        // 세로
        for (int i = 0; i < 3; i++) {

            // 기준을 잡는다.
            for (int j = 0; j < 3; j++) {
                char base = inp[j].charAt(i);

                // 기준을 잡고 돌린다.
                int diffCnt = 0;
                for (int k = 0; k < 3; k++) {
                    if (inp[k].charAt(i) != base) {
                        diffCnt++;
                    }
                }
                if (diffCnt == 1) {
                    cnt++;
                    break;
                }

            }
        }

        // 오른쪽 아래로 가는 대각선
        // 기준을 잡는다.
        for (int j = 0; j < 3; j++) {
            char base = inp[j].charAt(j);

            // 기준을 잡고 돌린다.
            int diffCnt = 0;
            for (int k = 0; k < 3; k++) {
                if (inp[k].charAt(k) != base) {
                    diffCnt++;
                }
            }
            if (diffCnt == 1) {
                cnt++;
                break;
            }
        }

        // 오른쪽 위로 가는 대각선
        // 기준을 잡는다.
        for (int j = 2; j >= 0; j--) {
            char base = inp[j].charAt(2-j);

            // 기준을 잡고 돌린다.
            int diffCnt = 0;
            for (int k = 2; k >= 0; k--) {
                if (inp[k].charAt(2-k) != base) {
                    diffCnt++;
                }
            }
            if (diffCnt == 1) {
                cnt++;
                break;
            }
        }

        System.out.print(cnt);
    }
}

// 가로 세로 대각선을 각각 모두 탐색한다.
// 같은수 2개, 다른 수 1개 이면 cnt++;