

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();

        int count = 0;
        while (start < end) {
            if (end % 2 == 0) {
                end /= 2;
            } else if (end % 10 == 1) {
                end -= 1;
                end /= 10;
            } else {
                System.out.print(-1);
                return;
            }
            count++;
        }

        System.out.print(end == start ? count + 1 : -1);

    }
}

// 어떻게 최대한 적은 수로 만들 것인가?
// x * 2
// x * 10 + 1
// 반대
// x / 2
// (x - 1) / 10
// 끝이 1인 경우와 2로 나눌 수 있는 경우는 양립될 수 없음.
// 즉 각 경우에 대해 하나만 적용할 수 있음.