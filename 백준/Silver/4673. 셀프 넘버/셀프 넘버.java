
import java.util.*;

public class Main {
    static Set<Integer> set;
    static boolean[] visited;
    public static void main(String[] args) {
        set = new HashSet<>();
        visited = new boolean[10001];

        for (int i = 1; i <= 10000; i++) {
            dfs(i);
        }

        for (int i = 1; i <= 10000; i++) {
            if (!set.contains(i)) {
                System.out.println(i);
            }
        }
    }

    private static void dfs(int i) {
        if (i > 10000) {
            return;
        }
        if (visited[i]) {
            return;
        }
        visited[i] = true;

        int bucketSelfNum = i;
        String strNum = String.valueOf(i);
        for (int j = 0; j < strNum.length(); j++) {
            bucketSelfNum += Integer.parseInt(String.valueOf(strNum.charAt(j)));
        }
        set.add(bucketSelfNum);
        dfs(bucketSelfNum);
    }
}

// n + n의 각자리 수
// 1부터 하나씩 늘려가며 수열을 만든다.
// 셋에 저장한다. 셀프넘버가 10000이 넘어가면 그만둔다.
// 다시 1부터 늘려가며 셋을 탐색한다.
// 셋에 contains하고 없으면 출력한다.
// 만들어진 숫자를 가지고 또 만들 수 있다. -> 무한
// 어떻게 무한을 탈피할 수 있을까?
// dfs로 이미 포함된 숫자가 있으면 그만둔다.
