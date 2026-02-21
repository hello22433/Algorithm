import java.io.*;
import java.math.BigInteger;
import java.util.*;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        String[] yoil = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};

        int[] daysOfmonths = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int daysOfDifference = 0 + y - 1;

        for (int i = 1; i <= x - 1; i++) {
            daysOfDifference = daysOfDifference + daysOfmonths[i];
        }

//        1월7일(일) 1월1일(월) -> 무슨요일인가?
//
//        x-1 어떻게 환산?<-(x월 y일) - 1(1월 1일) = 일의 차이

        System.out.print(yoil[daysOfDifference % 7]);

    }
}

// 1월 1일이 월요일 -> x월 y일까지의 차이를 일로 환산 -> 140일 차이가 난다! -> 7로나눠떨어지면 월요일이겠죠
// -> 나머지 1이면 월+1 화->
