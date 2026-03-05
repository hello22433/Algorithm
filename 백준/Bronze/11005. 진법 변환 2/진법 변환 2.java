import java.io.*;
import java.math.BigInteger;
import java.util.*;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String line;

//        st = new StringTokenizer(br.readLine());
//
//        int x = Integer.parseInt(st.nextToken());
//        int y = Integer.parseInt(st.nextToken());
//        int z = Integer.parseInt(st.nextToken());


        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int B = sc.nextInt();


        StringBuilder sb = new StringBuilder();
        while (N != 0) {
            int num = N % B;
            N /= B;

            char result;

            if (num >= 10) result = (char) (num + 'A' - 10);
            else result = (char) (num + '0');

            sb.append(result);
        }

        System.out.println(sb.reverse());





    }
}
