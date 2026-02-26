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

        int n = sc.nextInt();

        int sum = 1;
        int pre = 0;

        for (int i = 2; i <= n; i++) {
            int temp = sum;
            sum = sum + pre;
            pre = temp;
        }

        System.out.println(sum);







    }
}
