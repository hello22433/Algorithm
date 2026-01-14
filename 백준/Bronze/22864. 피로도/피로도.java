import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int M = sc.nextInt();

        int fatigue = 0;
        int score = 0;

        for (int i = 1; i <= 24; i++) {
            if (fatigue + A > M) {
                fatigue = Math.max(fatigue-C,0);
            } else {
                fatigue += A;
                score += B;
            }
        }
        System.out.print(score);
    }
}