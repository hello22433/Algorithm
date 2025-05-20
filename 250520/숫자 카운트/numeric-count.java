import java.util.Scanner;
public class Main {
    static int n; // expectedArr(예상수), count1(strike), count2(ball) 의 길이
    static int[] expectedArr; 
    static int[] count1;
    static int[] count2;

    public static boolean isValid(int num) {
        String strNum = String.valueOf(num);
        if (strNum.charAt(0)==strNum.charAt(1) || strNum.charAt(0)==strNum.charAt(2) || strNum.charAt(1)==strNum.charAt(2)) return false;
        if (strNum.charAt(0)==0 || strNum.charAt(1)==0 || strNum.charAt(2)==0) return false;

        for (int idx = 0; idx < n; idx++) {
            if (!(checkBall(num, idx) && checkStrike(num, idx))) {
                return false;
            }
        }

        return true;
    }

    public static boolean checkBall(int num, int idx) {
        // num과 expectedArr[idx]의 각 char이 일치는 하지 않으면서 같은 수는 몇 개인가?
        // 만약 count2[idx]와 일치한다면 true를 반환한다. 아니라면 false를 반환
        int ballCnt = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i==j) continue;
                if (String.valueOf(num).charAt(i) == String.valueOf(expectedArr[idx]).charAt(j)) {
                    ballCnt++;
                }
            }
        }
        if (ballCnt == count2[idx]) return true;

        return false;
    }

    public static boolean checkStrike(int num, int idx) {
        // num과 expectedArr[idx]의 각 char이 일치하는 수가 몇 개인가?
        // 만약 count1[idx]와 일치한다면 true를 반환한다. 아니라면 false를 반환
        int strikeCnt = 0;
        for (int i = 0; i < 3; i++) {
            if (String.valueOf(num).charAt(i) == String.valueOf(expectedArr[idx]).charAt(i)) {
                strikeCnt++;
            }
        }
        if (strikeCnt == count1[idx]) return true;

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        expectedArr = new int[n];
        count1 = new int[n];
        count2 = new int[n];
        for (int i = 0; i < n; i++) {
            expectedArr[i] = sc.nextInt();
            count1[i] = sc.nextInt();
            count2[i] = sc.nextInt();
        }

        int cnt = 0 ;
        for (int i = 123; i <= 987; i++) {
            if (isValid(i)) {
                cnt++;
            }
        }

        System.out.print(cnt);
        
        // 모든 가능한 수를 돌아가며
        // 모든 조건수와 스트라이크와 볼이 일치하는지를 체크한다.
        // 조건을 모두 통과하면(스트라이크, 볼 수, 0이 들어가지 않음, 서로다른 숫자로 3자리로 이루어짐)
    }
}