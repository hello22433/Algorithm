import java.io.*;
import java.math.BigInteger;
import java.util.*;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

//        st = new StringTokenizer(br.readLine());
//
//        int x = Integer.parseInt(st.nextToken());
//        int y = Integer.parseInt(st.nextToken());
//        int z = Integer.parseInt(st.nextToken());
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        for (int i = 0; i < s.length(); i++) {
            int cnt = i + 1;
            System.out.print(s.charAt(i));

            if (cnt % 10 == 0) {
                System.out.println();
            }
        }






    }
}

// 1월 1일이 월요일 -> x월 y일까지의 차이를 일로 환산 -> 140일 차이가 난다! -> 7로나눠떨어지면 월요일이겠죠
// -> 나머지 1이면 월+1 화->
