
import java.util.*;

public class Main {
    static int N ;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int[] ops;
    static int[] nums;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        ops = new int[4];
        for (int i = 0; i < 4; i++) {
            ops[i] = sc.nextInt();
        }

        dfs(1, nums[0]);
        System.out.println(max);
        System.out.println(min);
    }

    private static void dfs(int numsIdx, int sum) {
        if (numsIdx == N) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (ops[i] > 0) {
                ops[i]--;
                int nextSum = calculate(sum, nums[numsIdx], i);
                dfs(numsIdx+1, nextSum);
                ops[i]++;
            }
        }
    }

    private static int calculate(int sum, int num, int i) {
        switch (i) {
            case 0: return sum + num;
            case 1: return sum - num;
            case 2: return sum * num;
            case 3:
                if (sum < num) return -(-sum / num);
                return sum / num;
        }
        return 0;
    }
}



// + = * /
// 모든 숫자는 그대로에 연산자의 순서만 바뀌면 된다.
// 배열에 넣고 완전탐색을 하면 된다.
// result를 전달하는 방식으로 dfs를 돌린다.
// 백트래킹으로 부호를 완전탐색한다.
// nums 인덱스를 넘긴다.
// sum을 넘긴다.
// 만약 nums인덱스가 N에 도달하면 sum의 최대 최소를 갱신한다.
// + - * / 를 인덱스 순으로 배열에 담고 0초과면 1을 감소시키고
// 그 전에 sum을 계산해야 한다.
// sum, 현재nums수, 부호인덱스를 계산 함수에 넘긴다.
// 부호인덱스가 0이면 + 1이면 ...
// 다음 수로 넘어간다. (nums인덱스+1넘김)
// 이후 부호 수를 원상복귀시킨다.