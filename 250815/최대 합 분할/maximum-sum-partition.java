import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n + 1];
        int totalSum = 0;
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
            totalSum += arr[i];
        }

        // dp[j]: 현재까지의 숫자들을 사용했을 때,
        // (A그룹의 합 - B그룹의 합)에 해당하는 인덱스 'j'에
        // A그룹의 최대 합을 저장합니다.
        int offset = totalSum;
        int dpSize = 2 * totalSum + 1;
        
        // 메모리 최적화를 위해 1차원 배열 두 개를 번갈아 사용하는 대신,
        // 1차원 배열 하나를 다음 상태(nextDp)를 계산하는 데 사용합니다.
        int[] dp = new int[dpSize];
        
        // DP 배열을 -1로 초기화하여 '도달할 수 없는 상태'를 표시합니다.
        Arrays.fill(dp, -1);

        // 초기 상태(Base Case): 숫자를 하나도 사용하지 않았을 때,
        // 합의 차이는 0이며, 이때 A그룹의 합은 0입니다.
        dp[offset] = 0;

        // 각 숫자를 순회합니다.
        for (int i = 1; i <= n; i++) {
            int currentNum = arr[i];
            int[] nextDp = dp.clone(); // 현재 숫자를 C그룹에 넣는 경우를 기본으로 복사합니다.

            // 이전 단계(dp)에서 도달 가능했던 모든 차이(j)를 확인합니다.
            for (int j = 0; j < dpSize; j++) {
                // 이전 단계에서 도달할 수 없었던 상태는 건너뜁니다.
                if (dp[j] == -1) {
                    continue;
                }
                
                int prevSumA = dp[j];

                // 선택 1: 현재 숫자를 A 그룹에 넣는 경우
                // A의 합이 증가하고, 차이도 그만큼 증가합니다.
                if (j + currentNum < dpSize) {
                    nextDp[j + currentNum] = Math.max(nextDp[j + currentNum], prevSumA + currentNum);
                }

                // 선택 2: 현재 숫자를 B 그룹에 넣는 경우
                // B의 합이 증가하고, 차이는 그만큼 감소합니다. A의 합은 그대로입니다.
                if (j - currentNum >= 0) {
                    nextDp[j - currentNum] = Math.max(nextDp[j - currentNum], prevSumA);
                }
            }
            dp = nextDp; // 다음 상태를 현재 상태로 갱신합니다.
        }

        // 최종 결과: 모든 숫자를 사용했을 때, 합의 차이가 0(인덱스: offset)일 때의 A그룹의 최대 합.
        // 만약 결과가 0 이하면, 가능한 최대 합이 0이라는 의미입니다(예: A, B 그룹이 모두 비어있는 경우).
        System.out.println(dp[offset] > 0 ? dp[offset] : 0);
    }
}