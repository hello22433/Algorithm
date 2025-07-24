import java.util.*;
public class Main {
    static int n;
    static int cnt = 0;
    static int[] arr;
    static int[] count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];

        dfs(0);
        System.out.print(cnt);
    }

    public static void dfs(int depth) {
        if (depth == n) {

            // 공통 : 끊겨서 나오면 안됨. 이미 체크된 적이 있으면 cnt 더하면 안됨
            // 1 : 끊기지만 않으면 됨
            // 2 : 나온게 짝수면 됨
            // 3 : 나온게 3의 배수면 됨
            // 4 : 나온게 4의 배수면 됨

            count = new int[5];
            boolean check = true;
            int curVal = arr[0];
            count[curVal] += 1;
            for (int i = 1; i < n; i++) {
                if (curVal != arr[i]) {
                    if (curVal == 2 && count[curVal] % 2 != 0) check = false;
                    if (curVal == 3 && count[curVal] % 3 != 0) check = false;
                    if (curVal == 4 && count[curVal] % 4 != 0) check = false;

                    curVal = arr[i];
                    count[curVal] += 1;
                } else {
                    count[curVal] += 1;
                }
            }

            if (count[2] % 2 != 0) check = false;
            if (count[3] % 3 != 0) check = false;
            if (count[4] % 4 != 0) check = false;

            if (check) cnt++;

            return;
        }

        for (int i = 1; i <= 4; i++) {
            arr[depth] = i;
            dfs(depth+1);
        }
    }
}

// 1~4
// 해당 숫자만큼 연달아 같은 숫자가 나오는 수 : 아름다운 수
// 10자리를 채운다.
// 짝으로 묶어야 한다. 만약 끝가지 돌았는데 짝이 안 맞춰진게 있다면 아름답지 않음.