
import java.io.BufferedReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] houses = new int[N];

        for (int i = 0; i < N; i++) {
            houses[i] = sc.nextInt();
        }
        Arrays.sort(houses);
        int medium = houses[(N-1) / 2];
        System.out.println(medium);


        //

    }
}

// 가장 중앙에 집이 있어야 한다.
// 6 2 2
// 4 2 4
// 8 6 4
// 8 4 2
// 더 밀집되어 있는 곳에 집이 있어야 한다.
// 정렬해서 제일 중앙에 있는 값? 중앙값은 거리의 합을 최소화하는 특징이 있다.
// 홀수일때는 N/2 짝수일때는 중앙값이 두개가 될 수 있는데 더 작은 값을 골라야 한다.  5개중에3번째,인덱스2 5-1/2
// 짝수일떄는 4중에 2번째 1번인덱스 4-1 / 2 -> 작은수니까 버림그대로 냅두기