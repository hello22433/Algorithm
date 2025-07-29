import java.util.Scanner;

public class Main {
    static int n, m;
    static int[] A;
    static boolean[] visited;
    static int maxXorValue = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        A = new int[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        // Please write your code here.

        dfs(0, 0, 0);
        System.out.print(maxXorValue);
    }

    public static void dfs(int startIdx, int depth, int resultXOR) {
        if (depth == m) {
            maxXorValue = Math.max(maxXorValue, resultXOR);
            return;
        }

        for (int i = startIdx; i < n; i++) {
            
            if (!visited[i]) {
                visited[i] = true;
                dfs(i + 1, depth + 1, resultXOR ^ A[i]);
                visited[i] = false;
            }

        }
    }
}

// N 개의 음이 아닌 정수!
// M개의 숫자를 뽑아, 모두 XOR한 결과의 최댓값을 출력
//

// 