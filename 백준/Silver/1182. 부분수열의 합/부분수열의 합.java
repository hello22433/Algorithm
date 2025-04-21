
import java.util.*;

public class Main {
    static int N ;
    static int S;
    static int[] arr;
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        dfs(0,0,0);
        System.out.println(count);

    }

    private static void dfs(int idx, int sum, int cnt) {
        if (idx == N) {
            if (sum == S && cnt > 0) {
                count++;
            }
            return;
        }

        // 현재 수 포함
        dfs(idx+1, sum+arr[idx], cnt+1);
        
        // 현재 수 포함x
        dfs(idx+1, sum, cnt);
    }
}




// 모든 수들의 조합을 구하면 된다.
//