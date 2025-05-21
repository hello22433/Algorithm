import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int ACopy = A;
        int BCopy = B;

        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; ; i++) {
            A *= i;
            if (A > C) break;

            for (int j = 0; ; j++) {
                B *= j;

                if (A + B <= C) {
                    maxSum = Math.max(maxSum, A+B);
                } else {
                    break;
                }

                if (j != 0) B /= j;
                else B = BCopy;
            }

            if (i != 0) A /= i;
            else A = ACopy;
        }

        System.out.print(maxSum);
    }
}

// A를 여러번 더하기
// B를 여러번 더하기
// 