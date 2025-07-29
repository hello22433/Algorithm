import java.util.Scanner;

public class Main {
    static int n,m;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        // Please write your code here.
        arr = new int[m];
        visited = new boolean[n+1];

        dfs(1, 0);
    }

    public static void dfs(int startNum, int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = startNum; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i;
                dfs(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }
}

// 1 ~ N 
// M 개의 숫자를 골라 만들 수 있는 모든 조합을 구해라 
// 오름차순으로 하나의 조합을 출력해야 한다.

// 