import java.util.*;

public class Main {
    static int n;
    static int cnt = 0;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        dfs(0);
        System.out.println(cnt);
    }

    public static void dfs(int depth) {
        if (depth == n) {
            if (isBeautiful()) cnt++;
            return;
        }

        for (int i = 1; i <= 4; i++) {
            arr[depth] = i;
            dfs(depth + 1);
        }
    }

    public static boolean isBeautiful() {
        int[] count = new int[5]; // 1~4 숫자의 등장 개수
        Set<Integer> used = new HashSet<>(); // 블록 중복 체크
        int i = 0;

        while (i < n) {
            int cur = arr[i];
            int j = i;

            // 같은 숫자가 끝날 때까지 탐색
            while (j < n && arr[j] == cur) {
                j++;
            }

            // 이 숫자가 예전에 다른 블록으로 등장한 적이 있다면 끊긴 것!
            if (used.contains(cur)) return false;
            used.add(cur);

            count[cur] += (j - i); // 이번 블록 길이만큼 더함

            i = j; // 다음 블록으로 이동
        }

        // 개수 조건 확인
        if (count[2] % 2 != 0) return false;
        if (count[3] % 3 != 0) return false;
        if (count[4] % 4 != 0) return false;

        return true;
    }
}
