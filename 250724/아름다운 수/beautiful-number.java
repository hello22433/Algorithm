import java.util.*;
public class Main {
    static int n;
    static int cnt = 0;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        visited = new boolean[5];

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

            int oneCnt = 0;
            int twoCnt = 0;
            int thrCnt = 0;
            int fourCnt = 0;

            boolean check = true;
            int firstVal = arr[0];
            if (firstVal == 1) oneCnt++;
            if (firstVal == 2) twoCnt++;
            if (firstVal == 3) thrCnt++;
            if (firstVal == 4) fourCnt++;
            visited[firstVal] = true;
            for (int i = 1; i < n; i++) {
                if (firstVal != arr[i]) {
                    if (!visited[arr[i]]) {
                        firstVal = arr[i];
                        visited[firstVal] = true;
                        if (firstVal == 1) oneCnt++;
                        if (firstVal == 2) twoCnt++;
                        if (firstVal == 3) thrCnt++;
                        if (firstVal == 4) fourCnt++;
                    } else {
                        check = false;
                        break;
                    }
                } else {
                    // 미리 해도 되는데 어차피 다 처리 해야하니까 상관없는듯
                    if (firstVal == 1) oneCnt++;
                    if (firstVal == 2) twoCnt++;
                    if (firstVal == 3) thrCnt++;
                    if (firstVal == 4) fourCnt++;
                }
            }

            if (twoCnt % 2 != 0) check = false;
            if (thrCnt % 3 != 0) check = false;
            if (fourCnt % 4 != 0) check = false;

            if (check) cnt++;

            for (int i = 0; i <= 4; i++)
                visited[i] = false;

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