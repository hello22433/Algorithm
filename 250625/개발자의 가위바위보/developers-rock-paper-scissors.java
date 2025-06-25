import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] recordFight = new int[n][2];
        for(int i = 0; i < n; i++){
            int first = sc.nextInt();
            int second = sc.nextInt();

            recordFight[i] = new int[]{first, second};
        }
        
        int firstWinMaxScore = makeFirstWinMaxScoreInRockScissorsPaper(recordFight, n);
        System.out.print(firstWinMaxScore);
        
    }

    public static int makeFirstWinMaxScoreInRockScissorsPaper(int[][] recordFight, int n) {
        int sumFirstWinScore1 = 0;
        int sumFirstWinScore2 = 0;
        int sumFirstWinScore3 = 0;
        int sumFirstWinScore4 = 0;
        int sumFirstWinScore5 = 0;
        int sumFirstWinScore6 = 0;
        for (int i = 0; i < n; i++) {
            int firstNum = recordFight[i][0], secondNum = recordFight[i][1];

            sumFirstWinScore1 += makeFirstWinScoreInrockScissorsPaper(SRP[firstNum], SRP[secondNum]);
            sumFirstWinScore2 += makeFirstWinScoreInrockScissorsPaper(SPR[firstNum], SPR[secondNum]);
            sumFirstWinScore3 += makeFirstWinScoreInrockScissorsPaper(RSP[firstNum], RSP[secondNum]);
            sumFirstWinScore4 += makeFirstWinScoreInrockScissorsPaper(RPS[firstNum], RPS[secondNum]);
            sumFirstWinScore5 += makeFirstWinScoreInrockScissorsPaper(PRS[firstNum], PRS[secondNum]);
            sumFirstWinScore6 += makeFirstWinScoreInrockScissorsPaper(PSR[firstNum], PSR[secondNum]);
        }
        int[] sumFirstWinScore = {sumFirstWinScore1, sumFirstWinScore2, sumFirstWinScore3, sumFirstWinScore4, sumFirstWinScore5, sumFirstWinScore6};

        int maxSum = 0;
        for (int i = 0; i < 6; i++){
            maxSum = Math.max(maxSum, sumFirstWinScore[i]);
        }
        return maxSum;
    }

    public static int makeFirstWinScoreInrockScissorsPaper(String firstSRP, String secondSRP) {
        // 0 가위 바위 보
        // 1 가위 보 바위
        // 2 바위 가위 보
        // 3 바위 보 가위
        // 4 보 바위 가위
        // 5 보 가위 바위
        if (firstSRP.equals("scissors")) {
            if (secondSRP.equals("paper")) {
                return 1;
            }
        } else if (firstSRP.equals("rock")) {
            if (secondSRP.equals("scissors")) {
                return 1;
            }
        } else if (firstSRP.equals("paper")) {
            if (secondSRP.equals("rock")) {
                return 1;
            }
        }
        return 0;
    }

    static String[] SRP = {"", "scissors", "rock", "paper"};
    static String[] SPR = {"", "scissors", "paper", "rock"};
    static String[] RSP = {"", "rock" , "scissors", "paper"};
    static String[] RPS = {"", "rock", "paper", "scissors"};
    static String[] PRS = {"", "paper", "rock", "scissors"};
    static String[] PSR = {"", "paper", "scissors", "rock"};
}

// 문제
// 개발자 두 명 가위바위보
// 가위바위보 == 숫자 1 2 3 == 뭘 나타내는지는(각각 가위, 바위 보) 정해지지 않음
// 가위바위보를 한 횟수, 어떤 것을 냈는지 숫자로 주어짐

// 요구 사항
// 숫자와 가위바위보를 매칭시킨다. => 첫 번쩨 개발자가 이기는 횟수가 최대가 되도록 !

// 이해
// 가위 바위 보를 1 2 3에 넣어서 첫 번째 개발자가 이기는 경우의 수를 늘려야 한다.
// 1이 가위인 경우, 2가지 경우
// 1이 바위인 경우, 2가지 경우
// 1이 보인 경우, 2가지 경우
// 이렇게 정하게 되면, first와 second가 몇인지에 따라서 결과가 달라진다.
// 계산 과정을 어떻게 구현할 것인가?
// 맵으로 만든다. -> map[first] 
// 
// 1이 이기면 
// 