

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Integer[] crack = new Integer[N];
        for (int i = 0; i < N; i++) {
            crack[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(crack, Collections.reverseOrder());

        int firstValue = crack[0];
        int tapeCount = 0;
        for (int i = 1; i < N; i++) {
            if (firstValue - crack[i] >= L) {
                firstValue = crack[i];
                tapeCount++;
            }
        }

        System.out.println(tapeCount+1);
    }
}

// 물이 새는 곳을 배열에 저장하여 내림차순으로 정렬한다.
// 최초값을 변수에 저장한다.
// 이후 값을 탐색하면서 최초값-현재값이 L보다 커지면 최초값을 갱신하고 테이프를 추가한다.
// 탐색을 마치고 테이프를 하나 추가한다.