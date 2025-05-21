import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        int[][] ranking = new int[k][n];
        boolean[][] checkFrontMan = new boolean[n+1][n+1];

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                ranking[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                for (int l = j; l >= 0; l--) {
                    checkFrontMan[ranking[i][j]][ranking[i][l]] = true;
                }
            }
        }

        int cnt = 0;
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if (!checkFrontMan[i][j]) {
                    cnt++;
                }
            }
        }

        System.out.print(cnt);
    }
}

// int[N+1][N+1] makeIndividualRanking를 만든다. 1부터 N명 각각의 순위를 기록하는 배열이다.
// ranking[i][j]... makeIndividualRanking[ranking[i][j]][j+1] += 1;
// makeIndividualRanking[i][j] 을 돌면서  값이 0이 아니라면 n-j값으로 최소값을 갱신한다.(i 돌때마다 리뉴얼)
// 더한다.
// 나의 뒤에 있는 값이 항상 나의 랭킹보다 낮다는 증거가 없다. 
// i번째 시합의 순위표
// 
// checkFrontMan[n+1][n+1]
// ranking을 돈다.
// ranking[i][j]사람의 앞에 있는 사람을 체크해야 한다.
// ranking[i][k]. for (int k = j-1; k >= 0; k--)  
// checkFrontMan[ranking[i][j]][ranking[i][k]] = 1; (앞에있는 사람의 번호에 체크)
// checkFrontMan를 돈다.(1부터 n까지) 만약 값이 0이라면 i앞에 j라는 사람이 앞에 없다는 얘기이므로
// 카운트한다.