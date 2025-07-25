import java.util.*;

public class Main {
    static int maxCnt = 0;
    static List<int[]> lines;
    static int[][] segments;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        segments = new int[n][2];
        for (int i = 0; i < n; i++) {
            segments[i][0] = sc.nextInt();
            segments[i][1] = sc.nextInt();
        }
        // Please write your code here.

        lines = new ArrayList<>();

        dfs(0);
        System.out.print(maxCnt);
    }

    public static boolean overlapped(int one, int two) {
        int[] a = lines.get(one);
        int[] b = lines.get(two);

        int a1 = a[0];
        int a2 = a[1];
        int b1 = b[0];
        int b2 = b[1];

        if ((a1 >= b1 && a1 <= b2) || (a2 >= b1 && a2 <= b2)
            || (b1 >= a1 && b2 <= a2) || (b2 >= a1 && b2 <= a2)) return true;
        
        return false;
    }

    public static boolean possible() {
        // 모든 조합의 선분이 겹치는지 체크해야 함.
        for (int i = 0; i < lines.size(); i++) {
            for (int j = i+1; j < lines.size(); j++) {
                if (overlapped(i, j)) return false;
            }
        }
        return true;
    }

    public static void dfs(int depth) {
        if (depth == n) {
            if (possible()) {
                maxCnt = Math.max(maxCnt, lines.size());
            }
            return;
        }

        lines.add(segments[depth]);
        dfs(depth+1);
        lines.remove(segments[depth]);
        dfs(depth+1);

    }
}




// N개의 선분
// 서로 겹치지 않고 가장 많이 골라야 한다.
// 끝점 공유도 겹친 것임!

// 개수 N
// N줄에 걸쳐, 각 선분의 정보 
// 
// 조합으로 골라야 한다. (순서는 상관 x)
// A의 시작점이 B의 끝점보다 커야 한다. 
// 또는 A의 끝점이 B의 시작점보다 작아야 한다.  <=> B의 시작점이 A의 끝점보다 커야 한다. 


// 고르고 안 고르고를 택한다.
// 골랐던 안 골랐던 하나의 선택이기 때문에, +1 한다.
// cnt가 n에 달하면 고른 선분이 모두 겹치지 않는지 확인한다.
// 하나라도 겹치지 아니하면 고른 선분들의 개수로 최대값 갱신한다.