

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        if (N <= K) {
            System.out.println(0);
            return;
        }

        Integer[] censors = new Integer[N];
        for (int i = 0; i < N; i++) {
            censors[i] = sc.nextInt();
        }
        Arrays.sort(censors, (a,b) -> b-a);
        long result = 0;
        Integer[] diff = new Integer[N-1];
        for (int i = 0; i < N-1; i++) {
            diff[i] = censors[i] - censors[i+1];
        }

        Arrays.sort(diff, (a,b) -> b-a);
        for (int i = K-1; i < diff.length; i++) {
            result += diff[i];
        }
        System.out.println(result);
    }
}

// 3 6 7 8 10 12 14 15 18 20
// 거리차이가 곧 수신가능영역
// 차이를 구해서 내림차순으로 만들고 K-1개 만큼 뽑고 (집중국 1개씩 소모)
// K개 째에서 모든 영역을 커버한다. 즉 남은 거리차이를 모두 더한다. (남은 모든 수신가능영역을 커버한다)
// 이 문제에서 집중국의 수신 가능 영역은 고속도로 상에서 연결된 구간으로 나타난다고 하였다.
// 어디에 설치할 것에 대한 언급이 아닌 수신가능영역=연결된구간 으로만 나와있다. 해당 개념만 가지고 움직일것
// 수신가능영역을 모두 더하는 것이(하나의 집중국으로 모든 영역을 커버하는 경우) 거리의 합의 최댓값이다
// n개의 센서를 n-1개의 집중국이 커버하려면 거리가 먼 n-2개의 센서를 하나씩 먼저 처리하고 나머지 n-1, n번째의
// 센서를 나머지 센서로 처리하면 된다.
// 즉 n개의 센서를 k개의 집중국이 커버하려면 (n<k) 거리가 먼 k-1개의 센서를 먼저 처리하고
// 나머지 수신가능영역을 모두 더하면 그게 최소 수신영역의합
// K번째 집중국으로 나머지를 모두 커버해야 함
// k-1번째까지의 집중국은 하나의 센서를 각각 담당함
// 거리차의 배열은 1이 1-2의 거리차를 의미함. 즉 1과 2의 센서를 담당함. k가 k와 k+1의 거리차를 의미함.
// 우리는 k-1개의 센서를 각각 담당할 것임.
// 그렇기에 k-1부터 거리차 배열을 더해야 k-1과 k의 거리차임.
// 다만 K는 인덱스가 아닌 1-base이기에 -1을 해줘야 함.