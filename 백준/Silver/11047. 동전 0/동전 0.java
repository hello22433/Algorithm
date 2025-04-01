

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        String[] scLine = sc.nextLine().split(" ");
        int N = Integer.parseInt(scLine[0]);
        int K = Integer.parseInt(scLine[1]);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            stack.push(sc.nextInt());
        }

        int result = 0;
        int quoat;
        int remain;
        for (int i = 0; i < N; i++) {
            int poper = stack.pop();
            quoat = K / poper;
            result += quoat;
            K = K % poper;
            if (K == 0) {
                System.out.print(result);
                break;
            }
        }
    }
}

// 가장 큰 값부터 나눈다.
