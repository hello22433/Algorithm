
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int E = sc.nextInt();
        int S = sc.nextInt();
        int M = sc.nextInt();
        int e = 0;
        int s = 0;
        int m = 0;

        for (int i = 1; ; i++) {
            if (e == 15) {
                e = 1;
            } else {
                e += 1;
            }

            if (s == 28) {
                s = 1;
            } else {
                s += 1;
            }

            if (m == 19) {
                m = 1;
            } else {
                m += 1;
            }

            if (e == E && s == S && m == M) {
                System.out.println(i);
                return;
            }
        }
    }
}




// 1씩 더한다.