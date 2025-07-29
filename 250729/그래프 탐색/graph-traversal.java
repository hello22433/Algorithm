import java.util.*;
public class Main {
    static int n, m;
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static int maxPoints = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        arr = new ArrayList[n+1];
        visited = new boolean[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<Integer>();
        }

        int[] u = new int[m];
        int[] v = new int[m];
        for (int i = 0; i < m; i++) {
            u[i] = sc.nextInt();
            v[i] = sc.nextInt();

            arr[u[i]].add(v[i]);
            arr[v[i]].add(u[i]);
        }
        // Please write your code here.
        
        visited[1] = true;
        dfs(1);

        System.out.print(maxPoints);
    }

    public static void dfs(int point) {

        List<Integer> list = arr[point]; 

        // if (list.size() == 0) {
        //     return;
        // }

        for (int i = 0; i < list.size(); i++) {
            int nextPoint = list.get(i);

            if (!visited[nextPoint]) {
                maxPoints++;
                visited[nextPoint] = true;
                dfs(nextPoint);
            } 
            
        }
    }
}

// N 정점 M 간선 : 양방향
// 1 에서 시작하여, 주어진 간선을 따라 이동 -> 도달할 수 있는 서로 다른 정점의 수를 구하라
// 1

// xi yi 가 곧 1~n 이다
// 연결리스트를 만들자.