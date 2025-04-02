

import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int[] result = calculate(sc.nextInt());
            for (int re : result) {
                System.out.print(re + " ");
            }
            System.out.println();
        }
    }

    private static int[] calculate(int num) {
        int quoat = 0;
        int remain = 0;

        int[] money = new int[4];

        money[0] = num / 25;
        remain = num % 25;

        if (remain != 0) {
            money[1] = remain / 10;
            remain = remain % 10;
        }

        if (remain != 0) {
            money[2] = remain / 5;
            remain = remain % 5;
        }

        if (remain != 0) {
            money[3] = remain;
        }

        return money;
    }
}

// 25로 나눈다.
// 10으로 나눈다.
// 5로 나눈다.
// 1로 나눈다.
// 각각의 나머지를 나눌 것이고 결과값에 몫을 더할 것이다.