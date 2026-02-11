import java.util.*;

public class Main {
    static String N; // 입력받은 거대한 숫자 (문자열)
    static int L;    // 숫자의 길이 (최대 100,000)
    static long[][][][] memo; // 메모장: [인덱스][작은지여부][나머지][369유무]
    static final int MOD = 1000000007; // 결과가 너무 크니 이 숫자로 나눈 나머지 구함

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.next(); // 10^100000 같은 거대한 숫자를 문자열로 받음
        L = N.length();

        // 메모장 초기화: -1은 아직 계산 안 해봤다는 뜻
        // [자리수][N보다작아졌나][3으로나눈나머지][369포함여부]
        memo = new long[L][2][3][2];
        for (long[][][] d1 : memo)
            for (long[][] d2 : d1)
                for (long[] d3 : d2)
                    Arrays.fill(d3, -1);

        // 0번 자릿수부터 시작! 
        // 처음엔 N과 같으므로 isLess=0, 나머지=0, 369포함=0
        long result = dp(0, 0, 0, 0);

        // 결과에서 1을 빼줍니다 (우리의 로직은 0도 포함해서 계산하는데, 0은 박수를 안 치니까요)
        System.out.println((result - 1 + MOD) % MOD);
    }

    /**
     * @param idx     현재 채우고 있는 자릿수의 위치 (0 ~ L-1)
     * @param isLess  이미 앞자리에서 N보다 작은 숫자를 썼는가? (1이면 이제 아무 숫자나 막 써도 됨)
     * @param rem     지금까지 쓴 숫자들의 합을 3으로 나눈 나머지
     * @param has369  지금까지 3, 6, 9 중 하나라도 썼는가? (1이면 이미 박수 확정)
     */
    static long dp(int idx, int isLess, int rem, int has369) {
        // [기저 사례] 모든 자릿수를 다 채웠을 때!
        if (idx == L) {
            // 3의 배수(rem == 0)거나 3,6,9가 포함(has369 == 1)되어 있으면 박수 1번 추가!
            return (rem == 0 || has369 == 1) ? 1 : 0;
        }

        // [메모이제이션] 이미 계산한 적 있는 상황이면 장부에서 바로 꺼내줌
        if (memo[idx][isLess][rem][has369] != -1) {
            return memo[idx][isLess][rem][has369];
        }

        long count = 0;
        
        // 현재 자리에 쓸 수 있는 숫자의 상한선을 정함
        // 이미 앞자리에서 N보다 작은 걸 썼다면(isLess=1) 9까지 다 써도 되지만,
        // 아니면 현재 N의 자릿수 숫자(limit)까지만 써야 함 (N을 넘으면 안 되니까!)
        int limit = (isLess == 1) ? 9 : (N.charAt(idx) - '0');

        // 현재 자리에 0부터 limit까지 하나씩 넣어보자!
        for (int d = 0; d <= limit; d++) {
            
            // 다음 칸으로 넘겨줄 정보들 업데이트
            
            // 1. 다음 칸도 N보다 작은가? 
            // 이미 작거나(isLess==1), 이번에 쓰는 숫자(d)가 상한선(limit)보다 작으면 작아짐
            int nextIsLess = (isLess == 1 || d < limit) ? 1 : 0;
            
            // 2. 새로운 나머지 계산 (3의 배수 판정용)
            int nextRem = (rem + d) % 3;
            
            // 3. 369 포함 여부 업데이트
            // 이미 포함됐었거나, 이번에 쓰는 숫자가 3, 6, 9면 포함됨(1)
            int nextHas369 = (has369 == 1 || (d != 0 && d % 3 == 0)) ? 1 : 0;

            // 다음 자릿수(idx + 1)를 채우러 떠남!
            count += dp(idx + 1, nextIsLess, nextRem, nextHas369);
            count %= MOD; // 숫자가 너무 커지지 않게 계속 나눠줌
        }

        // 결과 저장하고 반환
        return memo[idx][isLess][rem][has369] = count;
    }
}