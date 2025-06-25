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
        
        
        int onefirstWin = 0;
        int twofirstWin = 0;
        int maxFirstWin = 0;
        for (int i = 0; i < n; i++) {
            int first = recordFight[i][0];
            int second = recordFight[i][1];

            // 1이 가위인 경우, 2가지 경우
            // 2가 바위, 3이 보
            // first가 1이면, second가 2이면 second가 이기고, second가 3이면 first가 이긴다.
            if (first == 1) {
                if (second == 2) {
                    // second 승이라 승점추가 x
                } else {
                    onefirstWin++;
                }
            } 

            // 2가 보, 3이 바위
            // first가 1이면, second가 2이면 first가 이기고, second가 3이면 second가 이긴다.
            if (first == 1) {
                if (second == 2) {
                    twofirstWin++;
                } else {
                    // second 승이라 승점추가 x
                }
            } 

            // // 1이 바위인 경우, 2가지 경우
            // // 2가 보, 3이 가위
            // firstWin = 0;
            // // first가 1이면, second가 2이면 second가 이기고, second가 3이면 first가 이긴다.
            // if (first == 1) {
            //     if (second == 2) {
            //         // second 승이라 승점추가 x
            //     } else {
            //         firstWin++;
            //     }
            // } 
            // maxFirstWin = Math.max(maxFirstWin, firstWin);

            // // 2가 바위, 3이 보
            // firstWin = 0;
            // // first가 1이면, second가 2이면 first가 이기고, second가 3이면 second가 이긴다.
            // if (first == 1) {
            //     if (second == 2) {
            //         firstWin++;
            //     } else {
            //         // second 승이라 승점추가 x
            //     }
            // } 
            // maxFirstWin = Math.max(maxFirstWin, firstWin);

            // // 1이 보인 경우, 2가지 경우
            // // 2가 가위, 3이 바위
            // firstWin = 0;
            // // first가 1이면, second가 2이면 second가 이기고, second가 3이면 first가 이긴다.
            // if (first == 1) {
            //     if (second == 2) {
            //         // second 승이라 승점추가 x
            //     } else {
            //         firstWin++;
            //     }
            // } 
            // maxFirstWin = Math.max(maxFirstWin, firstWin);

            // // 2가 바위, 3이 가위
            // firstWin = 0;
            // // first가 1이면, second가 2이면 first가 이기고, second가 3이면 second가 이긴다.
            // if (first == 1) {
            //     if (second == 2) {
            //         firstWin++;
            //     } else {
            //         // second 승이라 승점추가 x
            //     }
            // } 
            // maxFirstWin = Math.max(maxFirstWin, firstWin);
        }

        System.out.print(Math.max(onefirstWin, twofirstWin));
        
    }
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
// 
// 