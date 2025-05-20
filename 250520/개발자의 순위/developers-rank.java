import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        int[][] ranking = new int[k][n];
        int[][] makeIndividualRanking = new int[n+1][n+1];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                ranking[i][j] = sc.nextInt();
                makeIndividualRanking[ranking[i][j]][j+1] += 1;
            }
        }

        int sum = 0;
        for (int i = 1; i < n+1; i++) {
            int worstRank = Integer.MIN_VALUE; 
            for (int j = 1; j < n+1; j++) {
                if (makeIndividualRanking[i][j] != 0) worstRank = Math.max(worstRank, j);
            }
            if (worstRank != Integer.MIN_VALUE) sum += n - worstRank;
        }
        System.out.print(sum);
    }
}

// int[N+1][N+1] makeIndividualRanking를 만든다. 1부터 N명 각각의 순위를 기록하는 배열이다.
// ranking[i][j]... makeIndividualRanking[ranking[i][j]][j+1] += 1;
// makeIndividualRanking[i][j] 을 돌면서  값이 0이 아니라면 n-j값으로 최소값을 갱신한다.(i 돌때마다 리뉴얼)
// 더한다.
// 