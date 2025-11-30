import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        long[] dp = new long[K + 1];
        long INF = -100000000L;
        Arrays.fill(dp, INF);
        long globalMaxScore = INF;

        for (int i = 0; i < N; i++) {

            long curNum = arr[i];
            
            // 만약 양수라면 그냥 더하면 된다.
            // 음수의 개수가 0인 경우는 이 수부터 다시 시작할지 선택 가능하다.

            if (curNum > 0) {

                if (dp[0] != INF) dp[0] = curNum;
                else dp[0] = Math.max(dp[0] + curNum, curNum);

                for (int k = 1; k <= K; k++) {
                    dp[k] = dp[k] + curNum;

                    globalMaxScore = Math.max(dp[k], globalMaxScore);
                }
            } else {

                // 음수라면, 
                // 음수를 하나씩 민다.
                // 즉, dp[1]은 dp[2]가 된다. 여기서 한 사이클에서 값이 누적되지 않게 거꾸로 계산한다.
                // 0인 경우는 1이 된다. 

                for (int k = K; k >= 1; k--) {
                    
                    
                    if (dp[k-1] != INF) {

                        if (k==1) {
                            dp[k] = Math.max(dp[k-1] + curNum, curNum);
                        } else {
                            dp[k] = dp[k-1] + curNum;
                        }
                    } else if (k==1) {
                        dp[k] = curNum;
                    } else {
                        dp[k] = INF;
                    }

                    
                }
                dp[0] = INF;
                
            }

            for (int k = 0; k < K+1; k++) {
                globalMaxScore = Math.max(globalMaxScore, dp[k]);
            }

            
        }

        System.out.print(globalMaxScore);
        
    }
}

// 음수의 개수 k
// dp[k] : k개의 음수일 때 현재 최대값
// 카데인 알고리즘 + dp
// 
// 