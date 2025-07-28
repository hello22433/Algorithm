import java.util.*;
public class Main {
    static int n,m,k;
    static Map<Integer, Integer> chs;
    static int[] nums;
    static int maxScore = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        chs = new HashMap<>();
        nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        for (int ch = 1; ch <= k; ch++) {
            chs.put(ch, 1);
        }

        dfs(0);
        System.out.print(maxScore);
    }

    public static void dfs(int depth) {
        if (depth == n) {
            int mapScore = 0;
            for (Map.Entry<Integer, Integer> entry : chs.entrySet()) {
                if (entry.getValue() >= m) {
                    mapScore++;
                }
            }
            maxScore = Math.max(maxScore, mapScore);
            return;
        }

        for (int ch = 1; ch <= k; ch++) {
            chs.put(ch, chs.get(ch) + nums[depth]);

            dfs(depth + 1);

            chs.put(ch, chs.get(ch) - nums[depth]);
        }
    }
}


// 1 ~ M 
// K개의 말이 1에 모두 놓여있음.
// 모든 말을 적절히 이동시켜, 최대 점수를 내라.

// 각 턴에 어떤 말을 갈지를 정해야 한다.
// k개의 말이 각각 갈지 말지의 경우의 수를 정해야 한다.
// >