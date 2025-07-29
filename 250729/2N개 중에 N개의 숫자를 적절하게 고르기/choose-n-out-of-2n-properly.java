import java.util.Scanner;
public class Main {
    static int n;
    static int[] arr;
    static boolean[] visited;
    static int totalSum = 0;
    static int minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[2 * n];
        visited = new boolean[2 * n];

        for (int i = 0; i < 2 * n; i++) {
            arr[i] = sc.nextInt();
            totalSum += arr[i];
        }

        dfs(0, 0, 0);
        System.out.print(minDiff);
    }

    public static void dfs(int startIdx, int depth, int sum) {
        if (depth == n) {
            minDiff = Math.min(minDiff, Math.abs(sum-(totalSum - sum)));
            return;
        }

        for (int i = startIdx; i < 2*n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i+1, depth+1, sum + arr[i]);
                visited[i] = false;
            }
        }
    }
}

// 2N 개의 정수 수열 A
// 주어진 수를 각각 N개씩, 2개의 그룹으로 나눈다.
// 각 그룹 원소합의 차가 최소
// => 최대한 균형을 맞춰서 그룹을 나눈다.