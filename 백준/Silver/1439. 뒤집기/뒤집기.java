

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String N = sc.nextLine();

        char first = N.charAt(0);
        char pre = 'a';
        int count = 0;
        for (int i = 1; i < N.length(); i++) {
            if (first != N.charAt(i) && pre != N.charAt(i)) {
                count++;
            }
            pre = N.charAt(i);
        }
        System.out.print(count);
    }
}

// 300초, 60초, 10초
// 가장 큰 수로 나누는게 가능하면 나누고 아니면 나누지 않는다.