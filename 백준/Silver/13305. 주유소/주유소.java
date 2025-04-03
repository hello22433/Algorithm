

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main  {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long[] distance = new long[N-1];
        for (int i = 0; i < N-1; i++) {
            distance[i] = Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        long cur = Long.parseLong(st.nextToken());
        long sumDistance = 0;
        long result = 0;
        for (int i = 0; i < N-1; i++) {
            sumDistance += distance[i];
            long next = Long.parseLong(st.nextToken());
            if (next < cur) {
                result += sumDistance * cur;
                cur = next;
                sumDistance = 0;
            }
        }
        result += sumDistance * cur;
        System.out.print(result);
    }


}

// 현재 있는 주유소보다 더 낮은 가격의 주유소가 있다면
// 그 곳에 도착하기까지 최소한의 기름을 주유한다.
// 없다면 남은 거리만큼의 기름을 주유한다.
// todo : 더 낮은 가격의 주유소의 존재여부와 위치 어떻게 찾을까?
// 처음 값을 현재값에 저장한다.
// 이후 더 낮은 값이 나오면 누적거리와 현재 값을 곱하여 결과값에 더한다.
// 그리고 더 낮은 값을 현재값에 저장한다. 누적거리를 0으로 초기화 한다.
// 이를 반복한다.
// 마지막까지 안나올 경우를 대비하여 반복문이 끝나고 나서 누적거리와 현재 값을 곱하여 결과값에 더한다.
