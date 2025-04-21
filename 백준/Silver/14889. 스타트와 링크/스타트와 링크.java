
import java.util.*;

public class Main {
    static int n;
    static int[][] arr;
    static boolean[] selected;
    static int minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n][n];
        selected = new boolean[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        dfs(0,0);

        System.out.println(minDiff);
    }

    private static void dfs(int idx, int depth) {
        if (depth == n/2) {
            calcTeamAbility();
            return;
        }

        for (int i = idx; i < n; i++) {
            if (!selected[i]) {
                selected[i] = true;
                dfs(i+1, depth+1);
                selected[i] = false;
            }
        }
    }

    private static void calcTeamAbility() {
        int start = 0, link = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (selected[i] && selected[j]) {
                    start += arr[i][j] + arr[j][i];
                } else if (!selected[i] && !selected[j]) {
                    link += arr[i][j] + arr[j][i];
                }
            }
        }

        minDiff = Math.min(Math.abs(start-link), minDiff);
    }
}




//