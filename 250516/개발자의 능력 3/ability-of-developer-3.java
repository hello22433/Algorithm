import java.util.Scanner;

public class Main {
    static int[] ability = new int[6];
    static int abilitySum = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 6; i++) {
            ability[i] = sc.nextInt();
            abilitySum += ability[i];
        }
        // Please write your code here.
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < 6; i++) {
            for (int j = i+1; j < 6; j++) {
                for (int k = j+1; k < 6; k++) {
                    minDiff = Math.min(minDiff, getDiffer(i, j, k));
                }
            }
        }
        System.out.print(minDiff);
    }

    public static int getDiffer(int i, int j, int k) {
        int sum1 = ability[i] + ability[j] + ability[k];
        int sum2 = abilitySum - sum1;
        return Math.abs(sum1-sum2);
    }
}


// 