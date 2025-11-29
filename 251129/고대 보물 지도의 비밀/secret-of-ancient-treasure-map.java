import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 수열 길이
        int K = Integer.parseInt(st.nextToken()); // 허용 음수 개수

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // dp[k] : 현재 숫자를 포함하여 음수를 k개 사용했을 때의 최대 연속 합
        // 초기값은 매우 작은 수로 설정 (오버플로우 방지 위해 long 권장이나 문제 범위상 int도 가능할 수 있음)
        long[] dp = new long[K + 1];
        long INF = -10000000000L; // 충분히 작은 값
        Arrays.fill(dp, INF);

        long maxResult = INF;

        for (int num : arr) {
            if (num >= 0) {
                // [양수] 모든 상태에 더함. 단, dp[0]은 새로 시작 가능
                if (dp[0] == INF) dp[0] = num;
                else dp[0] = Math.max(dp[0] + num, num);
                
                // 나머지 k에 대해서는 단순히 더하기
                for (int k = 1; k <= K; k++) {
                    if (dp[k] != INF) dp[k] += num;
                }
            } else {
                // [음수] 뒤에서부터 갱신 (덮어쓰기 방지)
                for (int k = K; k >= 1; k--) {
                    if (dp[k - 1] != INF) {
                        dp[k] = dp[k - 1] + num;
                    } else {
                        dp[k] = INF;
                    }
                    
                    // 음수 1개로 새로 시작하는 경우(k=1) 체크
                    if (k == 1) {
                        dp[1] = Math.max(dp[1], num);
                    }
                }
                // 음수가 들어왔으니 0개 사용은 불가능
                dp[0] = INF; 
            }

            // 현재 단계에서 가능한 모든 k 중 최댓값 갱신
            for (long val : dp) {
                maxResult = Math.max(maxResult, val);
            }
        }

        System.out.println(maxResult);
    }
}