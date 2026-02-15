import java.io.*;
import java.util.*;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());

            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            int floor = n%h == 0 ? h : n%h;
            int room = (n-1) / h + 1;

            System.out.printf("%d%02d\n", floor, room);
        }

        // floor
        // n%h -> 나머지가 0이 되는 경우, h가 플로우가 된다.

        // 1 ~ h 1호
        // h+1 ~ 2h 2호
        // 2h + 1 ~ 3h 3호
        // 호수는 층수마다 묶인다. 3명인데 3층이면 3명은 하나의 묶음이 된다.
        // n/h로 하면 3번째 사람이 다른 묶음에 묶이기에 n-1로 제외시켜줘야한다.
        // 또한 나머지 몫은 0부터 시작하지만, 호실은 1부터 시작하므로 1을 더해주어야 한다.

    }

}

// 매핑하는식
// 3으로 나눈 몫으로 가는 식 (문자가 한 숫자에 4개인 경우는?)
//