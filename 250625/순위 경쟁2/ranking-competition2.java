import java.util.Scanner;
public class Main {
    static int AScore = 0;
    static int BScore = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int preRankingStatus = 0;
        int changeCnt = 0;

        for (int i = 0; i < n; i++) {
            char c = sc.next().charAt(0);
            int s = sc.nextInt();

            int makingRankingStatus = calculateScoreReturnRankingStatus(c, s);
            if (makingRankingStatus != preRankingStatus) {
                changeCnt++;
                preRankingStatus = makingRankingStatus;
            }
        }
        System.out.print(changeCnt);

        

    }

    public static int calculateScoreReturnRankingStatus(char man, int havingScore) {
        if (man == 'A') {
            AScore += havingScore;
        } else if (man == 'B') {
            BScore += havingScore;
        }

        return makeRankingStatus();
    }

    public static int makeRankingStatus() {
        if (AScore > BScore) {
            return -1;
        } else if (AScore == BScore) {
            return 0;
        } else {
            return 1;
        }
    }
}

// 문제
// A,B 각자 게임을 한다.
// 게임 결과에 따라 점수를 얻고 잃는다.
// 게임 점수가 바뀔 때마다 점수가 1등인 사람들을 모아 명예의 전당에 그 이름을 올린다.

// 요구사항
// 명예의 전당의 사람 조합이 몇 번 바뀌었는가?

// 이해
// 처음엔 모두 0점이기에 A,B 모두 명예의 전당에 올라감
// A가 크거나 같거나 B가 크거나
// 같은 경우 0, A가 큰 경우 -1, B가 큰 경우 1
