import java.util.Scanner;

public class Main {
    static int k, n;
    static int[] result;  // 선택한 숫자를 저장할 배열

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        n = sc.nextInt();

        result = new int[n];

        dfs(0);
    }

    public static void dfs(int depth) {
        if (depth == n) {
            // 결과 출력
            for (int i = 0; i < n; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= k; i++) {
            result[depth] = i;
            dfs(depth + 1);
        }
    }
}
