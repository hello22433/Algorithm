
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static List<Integer>[] tree;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(st.nextToken());
        tree = new ArrayList[N + 1];
        // 방문여부에 부모노드를 저장한다.
        parent = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 2; i <= N; i++) {
            st = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }

        dfs(1,0);

        for (int i = 2; i <= N; i++) {
            System.out.println(parent[i]);
        }
    }

    static void dfs (int start, int visit) {
        parent[start] = visit;

        for (int next : tree[start]) {
            if (parent[next] == 0) {
                dfs(next, start);
            }
        }
    }
}
