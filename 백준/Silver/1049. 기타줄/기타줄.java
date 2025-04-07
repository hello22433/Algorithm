

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] packageBox = new int[M];
        int[] eachBox = new int[M];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            packageBox[i] = Integer.parseInt(st.nextToken());
            eachBox[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(packageBox);
        Arrays.sort(eachBox);

        int quoat = 0;
        int remain = 0;
        int result = 0;
        if (packageBox[0] < eachBox[0] * 6) {
            quoat = N / 6;
            remain = N % 6;
            result += quoat * packageBox[0];
        } else {
            quoat = N / 6;
            remain = N % 6;
            result += quoat * (eachBox[0] * 6);

        }

        if (remain * eachBox[0] > packageBox[0]) {
            result += packageBox[0];
        } else {
            result += remain * eachBox[0];
        }

        System.out.println(result);
    }
}

// N을 저장한다. M만큼 돈다.
// 적어도 N개를 사는 거라는 걸 알아야 한다.
// 패키지로 모두 커버할지, 아니면 남은 수를 낱개로 살지를 정해야 한다.
// 패키지가 낱개로 산 만큼보다 싸다는 보장은 없다.
// 패키지 오름차순, 낱개 오름차순
// 낱개[0]*6 > 패키지[0] 일 경우 패키지[0]으로 나누기
// 이후 낱개[0]*나머지 와 패키지[0]을 하나 더 추가했을 때를 비교한다.