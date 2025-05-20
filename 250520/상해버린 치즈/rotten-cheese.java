import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int D = sc.nextInt();
        int S = sc.nextInt();

        int[][] eatRecord = new int[D][3];
        for (int i = 0; i < D; i++) {
            // 몇 번째 사람이
            eatRecord[i][0] = sc.nextInt();
            // 몇 번째 치즈를
            eatRecord[i][1] = sc.nextInt();
            // 언제 먹었는가
            eatRecord[i][2] = sc.nextInt();
        }

        int[][] sickedRecord = new int[S][2];
        for (int i = 0; i < S; i++) {
            // 몇 번째 사람이
            sickedRecord[i][0] = sc.nextInt();
            // 언제 확실히 아팠는가
            sickedRecord[i][1] = sc.nextInt();
        }

        int[] eatCheeseBeforeSicked = new int[M+1];
        
        boolean[] sickedPeople = new boolean[N+1];

        for (int i = 0; i < S; i++) {
            sickedPeople[sickedRecord[i][0]]  = true;
            boolean[] DuplicatedCheckCheese = new boolean[M+1];
            boolean[] DuplicatedCheckMen = new boolean[N+1];
            for (int j = 0; j < D; j++) {
                if (eatRecord[j][0] == sickedRecord[i][0] && eatRecord[j][2] < sickedRecord[i][1]) {
                    // 한 사람이 같은 치즈를 중복해서 먹을 경우는? => 
                    if (!DuplicatedCheckCheese[eatRecord[j][1]] || !DuplicatedCheckMen[eatRecord[j][0]]) {
                        DuplicatedCheckCheese = true;
                        DuplicatedCheckMen = true;
                        eatCheeseBeforeSicked[eatRecord[j][1]] += 1;
                    }
                }
            }
        }

        for (int i = 0; i < M+1; i++) {
            if (eatCheeseBeforeSicked[i] == S) {
                for (int j = 0; j < D; j++) {
                    if (eatRecord[j][1] == i) sickedPeople[eatRecord[j][0]] = true;
                }
            }
        }
        
        int cnt = 0;
        for (int i = 0; i < N+1; i++) {
            if (sickedPeople[i] == true) {
                cnt++;
            }
        }

        System.out.print(cnt);
    }
}

// N명이 M개의 치즈를 먹음
// 정확히 하나의 치즈가 상했다!
// D번의 기록 (어떤 사람이 어떤 치즈를 언제 먹었는지)
// S번의 기록 (어떤 사람이 언제 확실히 아팠는지)
// 기록 외에 아플 수도 있음
// 약이 최대 몇 개나 필요할까? 
// 먹은 1초 후에 아프다.
// 
// 상한 치즈의 조건 :
// 1) 아픈 사람 모두가 아프기 '전'에 '먹었어야' 한다.
// 아픈 사람을 체크한다. 아픈사람들의 아프기 전 먹었던 치즈들을 수집한다.
// 즉 sickedRecord[i][1]의 전에 먹었던 치즈들을 알아본다.
// 길이 M+1의 배열을 만들어 1~M까지의 치즈를 체크할 것이다. eatCheeseBeforeSicked
// eatRecord[j][0]과 sickedRecord[i][0]이 일치하고 eatRecord[j][2]가 sickedRecord[i][1]보다 작다면
// eatCheeseBeforeSicked[eatRecord[j][1]] 에 1을 더한다.
// 와중에 아픈 이들은 boolean[] sickedPeople = new boolean[N+1]로 체크할 것이다.  
// sickedPeople[sickedRecord[i][0]]  = true;
// 아픈 이들을 체크한 후, eatCheeseBeforeSicked 순회한다. S인 값이 있다면 해당 치즈는 상할 가능성이 있는 것이다.
// 상할 가능성이 있다면 이제 이외에 감염된 자가 있을지도 탐색해야 한다.
// if eatRecord[j][1] == i then sickedPeople[eatRecord[j][0]] = true;
// sickedPeople[i] 를 순회하여 true면 cnt++
// 
// 이외에 감염된 자가 있는지?
// 
// 