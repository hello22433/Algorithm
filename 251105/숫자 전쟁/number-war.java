import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }

        int[][] dp = new int[n + 1][n + 1];

        for (int i = n-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                // 카드 둘다 버림
                dp[i][j] = dp[i+1][j+1];

                // a<b 
                if (a[i] < b[j]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i+1][j]);
                }

                // a>b
                if (a[i] > b[j]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j+1] + b[j]);
                }
            }
        }
        

        System.out.println(dp[0][0]);
        
    }
}

// a<b : 남우점수 += a , a버림(a인덱스+1)
// a=b : a,b버림(a인덱스+1, b인덱스+1)
// 남우는 두 번째 플레이어

// 남아있는 첫번째 덱의 수(가리키는 카드 번호), 남아있는 두번째 덱의 수(동일), 남우의 점수, 상대방의 점수
// i j dp[i][j]:Max
// 
// 둘다 버리거나, 비교하거나
// 모두 고려해야 한다. 
// 만약 전에 경우가 존재한다면 가능하다
// dp[0][0] = 0 
// dp[1][0] = a의 0을 버렸다는 뜻이니까 a[0]<b[0]
// 즉, 현재 반복의 인덱스가 더 작고, 전의 값이 있으면 버릴 수 있다는 뜻이다.
//
// 시작하는 카드의 수가 동일하고(a,b 둘다), 남우의 점수가 동일하면 동일 한 것
// i j dp[i][j]:Max
// a를 버린다 -> a가 작아야 한다. -> i가 1 증가 -> dp[i+1][j] , dp[i][j]
// b를 버린다 -> b가 작아야 한다. (동시에 남우 점수를 더한다) -> j가 1 증가 -> dp[i][j+1] , dp[i][j]
// a,b를 버린다 -> 조건 없음 -> i,j 가 1씩 증가 -> dp[i+1][j+1] , dp[i][j] 
// 0 0 에서 시작했을 때의 값 dp[0][0] : 이게 정답인데..?
// dp[n-1][n-1] 부터 시작해서(마지막 덱) 0 0 까지 가야 한다
// n-1 n-1 에서 시작한다는 것은? a를 버린다는 것은? 
// i+1 j 는 i j 에서 a를 버린 것과 같다. 즉, i j 는 i+1 j에 의존한다. 
// i j+1 , i+1 j+1 도 마찬가지
// 즉, 뒷 값이 정해지면 앞 값이 정해지는데 그 중 최댓값으로 갱신되어야 한다. 
// 