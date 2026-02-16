import java.io.*;
import java.util.*;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());

        // arr[n][m] : n층 m호에 사는 사람의 수
        // 0층 1호부터 존재
        // 0층 i호에는 i명이 산다
        // a층 b호에는 arr[a-1][1] + ... + arr[a-1][b]만큼 산다

        int[][] arr = new int[15][15];

        for (int i = 1; i < 15; i++) {
            arr[0][i] = i;
        }

        for (int i = 1; i < 15; i++) {
            for (int j = 1; j < 15; j++) {
                arr[i][j] += arr[i][Math.max(1, j-1)] + arr[i - 1][j];

            }
        }

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            System.out.println(arr[k][n]);
        }
    }
}
