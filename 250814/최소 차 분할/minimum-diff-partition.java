import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            totalSum += arr[i];
        }

        // dp[s] = 합 s를 만들 수 있는 경우, 사용한 원소 개수 저장
        @SuppressWarnings("unchecked")
        Set<Integer>[] dp = new Set[totalSum / 2 + 1];
        for (int i = 0; i <= totalSum / 2; i++) {
            dp[i] = new HashSet<>();
        }
        dp[0].add(0); // 합 0, 원소 개수 0

        // 부분합 DP
        for (int num : arr) {
            for (int s = totalSum / 2; s >= num; s--) {
                for (int cnt : dp[s - num]) {
                    dp[s].add(cnt + 1);
                }
            }
        }

        int minDiff = Integer.MAX_VALUE;

        // 가능한 s 중에서 최소 차이 계산
        for (int s = 1; s <= totalSum / 2; s++) { // s=0은 한 그룹이 비어있으므로 제외
            for (int cnt : dp[s]) {
                if (cnt == 0 || cnt == n) continue; // 한쪽 그룹이 전부인 경우 제외
                int diff = Math.abs(totalSum - 2 * s);
                minDiff = Math.min(minDiff, diff);
            }
        }

        System.out.println(minDiff);
    }
}
