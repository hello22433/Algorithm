import java.io.*;
import java.util.*;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] baskets = new int[n+1];

        for (int i = 1; i <= n; i++) {
            baskets[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            for (int j = a; j <= (a+b)/2; j++) {
                int temp = baskets[j];
                baskets[j] = baskets[b-(j-a)];
                baskets[b-(j-a)] = temp;
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(baskets[i] + " ");
        }

        // arr[n][m] : n층 m호에 사는 사람의 수
        // 0층 1호부터 존재
        // 0층 i호에는 i명이 산다
        // a층 b호에는 arr[a-1][1] + ... + arr[a-1][b]만큼 산다


    }
}
