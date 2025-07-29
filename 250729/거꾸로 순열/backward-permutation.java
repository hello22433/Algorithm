import java.util.Scanner;
public class Main {
    static int n;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        visited = new boolean[n+1];

        dfs(0);
    }

    public static void dfs(int depth) {
        if (depth == n) {
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();

            return;
        }

        for (int num = n; num >= 1; num--) {
            if (!visited[num]) {
                visited[num] = true;
                arr[depth] = num;
                dfs(depth + 1);
                visited[num] = false;
            }
        }
    }
}

// 1 ~ N