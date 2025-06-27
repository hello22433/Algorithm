import java.util.*;
public class Main {
    static int aScore = 0;
    static int bScore = 0;
    static int cScore = 0;
    static int maxScore = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Set<Character> preWinners = new HashSet<>();
        preWinners.add('A');
        preWinners.add('B');
        preWinners.add('C');

        int changingWinnersCnt = 0;

        for (int i = 0; i < n; i++) {
            char c = sc.next().charAt(0);
            int s = sc.nextInt();

            provideScore(c, s);
            maxScore = findMaxScore();

            Set<Character> currentWinners = new HashSet<>();
            if (aScore == maxScore) currentWinners.add('A');
            if (bScore == maxScore) currentWinners.add('B');
            if (cScore == maxScore) currentWinners.add('C');

            if (!preWinners.equals(currentWinners)) {
                changingWinnersCnt++;
            }
            preWinners = new HashSet<>(currentWinners);
        }

        System.out.print(changingWinnersCnt);
    }

    public static void provideScore(char c, int s) {
        if (c == 'A') {
            aScore += s;
        } else if (c == 'B') {
            bScore += s;
        } else {
            cScore += s;
        }
    }

    public static int findMaxScore() {
        return Math.max(aScore, Math.max(bScore, cScore));
    }
}

// 문제
// A,B,C 각자 게임
// 점수 얻고 잃는다
// 점수 1등인 '사람들'을 모아 명예의 전당을 갱신
// 점수 변동 관련 정보가 주어짐

// 요구사항
// 명예전당 조합이 몇 번 바뀌었는지 출력

// 이해
// a,b,c 점수 각각을 int로 만든다.
// 명예의 전당에 모두가 올라간 상태로 시작한다. (모두가 같음)
// 점수가 주어지면 점수를 계산한다.
// 점수에 따라 명예의 전당에 사람을 올린다.
// set으로 처리할 건지, status 로 표시할 건지
// set으로 처리하자. 표시할 status가 많으므로
// preSet과 currentSet으로 비교한다.

// 점수를 입력받는다.
// 제일 높은 점수를 갱신한다. currentSet을 초기화한다.
// 제일 높은 점수를 구하고(Math.max) 그 점수와 일치하는 사람을 currentSet에 넣는다.
// 
// 이후 preSet에 currentSet을 대입한다.