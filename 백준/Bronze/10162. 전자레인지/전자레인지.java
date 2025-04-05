

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int quoat1 = N/300;
        int remain = N%300;

        int quoat2 = 0;
        if (remain != 0) {
            quoat2 = remain / 60;
            remain = remain % 60;
        }

        int quoat3 = 0;
        if (remain != 0) {
            quoat3 = remain / 10;
            remain = remain % 10;
        }

        if (remain != 0) {
            System.out.print(-1);
        } else {
            System.out.print(quoat1 + " " + quoat2 + " " + quoat3);
        }
    }
}

// 300초, 60초, 10초
// 가장 큰 수로 나누는게 가능하면 나누고 아니면 나누지 않는다.