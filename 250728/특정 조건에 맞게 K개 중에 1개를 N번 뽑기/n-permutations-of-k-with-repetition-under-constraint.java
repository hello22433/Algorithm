import java.util.Scanner;
public class Main {
    static int k, n;

    static int[] nums;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        n = sc.nextInt();
        nums = new int[n];

        dfs(0);
    }

    public static void dfs(int depth) {
        if (depth == n) {
            for (int i = 0; i < n; i++) {
                System.out.print(nums[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int num = 1; num <= k; num++) {
            if (depth < 2 || !(nums[depth-2] == nums[depth-1] && nums[depth-1] == num)) {
                nums[depth] = num;
                dfs(depth+1);
            }
        }
    }
}

// 
// K개 중에 1개를 N번 뽑자
// 
// 1 ~ K 중 하나를 고른다. N번 반복
// 모든 서로 다른 순서쌍
// 단, 연속하여 같은 숫자가 3번 이상 나오면 안 됨!
