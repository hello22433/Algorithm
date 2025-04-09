

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] levels = new int[T];
        for (int i = 0; i < T; i++) {
            levels[i] = sc.nextInt();
        }

        int preLevel = levels[levels.length - 1];
        int count = 0;
        for (int i = levels.length-2; i >= 0; i--) {
            if (preLevel <= levels[i]) {
                count += levels[i] - (preLevel - 1);
                preLevel = preLevel - 1;
            } else {
                preLevel = levels[i];
            }
        }
        System.out.println(count);

    }
}

// 거꾸로 돌려서 다음 수를 지금 수보다 1작게 만든다.

