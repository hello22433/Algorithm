

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int count = 1;

        while (true) {
            int result = 0;
            int L = sc.nextInt();
            int P = sc.nextInt();
            int V = sc.nextInt();
            if (L == 0) { return; }

            int quote = V / P;
            int remain = V % P;
            result += quote * L;
            if (remain > L) {
                result += L;
            } else {
                result += remain;
            }
            System.out.println("Case " + count + ": " + result);
            count++;
        }


    }
}

// V를 P로 나눈다.
// result += 몫*L
// result += 나머지