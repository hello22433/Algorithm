import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        int totalSum = 0;

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            totalSum += nums[i];
        }

        // 1. 총합이 홀수이면 두 그룹으로 나눌 수 없습니다.
        if (totalSum % 2 != 0) {
            System.out.println("No");
            return;
        }

        // 2. 목표 합은 총합의 절반입니다.
        int targetSum = totalSum / 2;

        // 3. DP 배열을 생성합니다. dp[i]는 합이 i가 되는 부분집합을 만들 수 있는지 여부입니다.
        boolean[] dp = new boolean[targetSum + 1];

        // 합이 0인 경우는 아무것도 선택하지 않으면 되므로 항상 가능합니다.
        dp[0] = true;

        // 4. 각 숫자를 순회하며 DP 배열을 갱신합니다.
        for (int num : nums) {
            // targetSum부터 거꾸로 순회해야 각 숫자가 한 번만 사용됩니다.
            for (int j = targetSum; j >= num; j--) {
                // j라는 합은,
                // 1) 현재 숫자를 사용하지 않고도 만들 수 있거나 (dp[j])
                // 2) (j - num)이라는 합을 만든 상태에서 현재 숫자를 더해서 만들 수 있습니다 (dp[j - num])
                dp[j] = dp[j] || dp[j - num];
            }
        }

        // 5. 최종적으로 목표 합을 만들 수 있는지 확인합니다.
        if (dp[targetSum]) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
