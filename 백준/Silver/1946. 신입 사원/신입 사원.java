

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int Test = Integer.parseInt(st.nextToken());

        for (int i = 0; i < Test; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[][] testcase = new int[N][2];
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                int[] bucket = new int[2];
                bucket[0] = Integer.parseInt(st.nextToken());
                bucket[1] = Integer.parseInt(st.nextToken());
                testcase[j] = bucket;
            }
            Arrays.sort(testcase, (a,b) -> {
                return a[0] - b[0];
            });
            int result = 0;
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < N; j++) {
                if (min > testcase[j][1]) {
                    min = testcase[j][1];
                    result++;
                }
            }
            System.out.println(result);
        }
    }
}

// 300초, 60초, 10초
// 가장 큰 수로 나누는게 가능하면 나누고 아니면 나누지 않는다.