
import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {
    static int N;
    static BufferedWriter bw;
    static boolean[] visited;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = sc.nextInt();
        arr = new int[N+1];
        visited = new boolean[N+1];
        for (int i = 1; i <= N; i++) {
            arr[i] = i;
        }
        
        List<Integer> list = new ArrayList<>();
        dfs(0, list);
        bw.close();
    }

    private static void dfs(int depth, List<Integer> list) throws IOException {
        if (depth == N) {
            for (int i = 0; i < N; i++) {
                bw.write(list.get(i) + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list.add(arr[i]);
                dfs(depth + 1, list);
                list.remove(list.size() -1);
                visited[i] = false;
            }
        }
    }
}

// M~N까지 탐색한다.
// i번째 수마다 1부터 i까지 탐색한다. (j)
// j로 나누었을 때 나머지가 없고 j와 같은 수가 몫으로 나오면 해당 수는 완전제곱수이므로
// count += 1 한다. break;
// 만약 몫이 j보다 커지면 더이상 완전제곱수로 볼 수 없으므로 break;
// countrk 0이면 -1출력

