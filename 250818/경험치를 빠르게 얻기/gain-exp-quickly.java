import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 퀘스트의 개수
        int m = sc.nextInt(); // 최소 목표 경험치
        int[] exp = new int[n];
        int[] time = new int[n];

        int totalExpSum = 0; // 모든 퀘스트를 수행했을 때 얻을 수 있는 최대 경험치
        for (int i = 0; i < n; i++) {
            exp[i] = sc.nextInt();
            time[i] = sc.nextInt();
            totalExpSum += exp[i];
        }
        
        // DP 배열을 생성합니다.
        // dp[i]는 정확히 i 만큼의 경험치를 얻기 위해 필요한 최소 시간을 저장합니다.
        int[] dp = new int[totalExpSum + 1];

        // DP 배열을 매우 큰 값으로 초기화합니다.
        // 이 값은 아직 해당 경험치에 도달할 수 없음을 의미합니다.
        // Integer.MAX_VALUE를 그대로 쓰면 시간 계산 시 오버플로우가 발생할 수 있어 약간 작은 값을 사용합니다.
        int INF = Integer.MAX_VALUE / 2;
        Arrays.fill(dp, INF);

        // 경험치 0을 얻는 데 걸리는 시간은 0입니다.
        dp[0] = 0;

        // 각 퀘스트에 대해 DP 테이블을 채워나갑니다.
        for (int i = 0; i < n; i++) {
            // 경험치를 큰 값부터 거꾸로 순회합니다.
            // 이는 각 퀘스트가 한 번만 사용되도록 보장합니다 (0/1 냅색).
            for (int j = totalExpSum; j >= exp[i]; j--) {
                // 현재 퀘스트(i)를 수행하여 경험치 j를 달성하는 경우
                // 기존에 j를 달성하는 시간과, (j - exp[i])를 달성하는 시간에 현재 퀘스트 시간을 더한 값을 비교합니다.
                if (dp[j - exp[i]] != INF) {
                    dp[j] = Math.min(dp[j], dp[j - exp[i]] + time[i]);
                }
            }
        }

        // 목표 경험치 M 이상을 달성하는 경우들 중에서 최소 시간을 찾습니다.
        int minTime = INF;
        for (int j = m; j <= totalExpSum; j++) {
            minTime = Math.min(minTime, dp[j]);
        }

        // 만약 minTime이 초기값 그대로라면 목표 경험치 M을 달성할 수 없는 경우입니다.
        if (minTime == INF) {
            System.out.println(-1); // 불가능한 경우 -1 출력
        } else {
            System.out.println(minTime);
        }
    }
}
