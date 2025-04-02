

import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int remain = 1000 - N;
        
        System.out.println(calculator(remain));

    }

    private static int calculator(int remain) {
        int quoat = 0;

        quoat += remain / 500;
        remain = remain % 500;

        if (remain != 0) {
            quoat += remain / 100;
            remain = remain % 100;
        }

        if (remain != 0) {
            quoat += remain / 50;
            remain = remain % 50;
        }

        if (remain != 0) {
            quoat += remain / 10;
            remain = remain % 10;
        }

        if (remain != 0) {
            quoat += remain / 5;
            remain = remain % 5;
        }

        if (remain != 0) {
            quoat += remain;
        }

        return quoat;
    }
}

// 1000 - 주어진값
// 500 100 50 10 5 1