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

        String N = sc.next();
        int B = sc.nextInt();
        int sum = 0;

        for (int i = 0; i < N.length(); i++) {
            int baseProduct = (int) Math.pow(B, N.length() - i - 1);
            char n = N.charAt(i);
            int num = (n - '0') * baseProduct;

            if (n >= 'A' && n <= 'Z') {
                num = (n - 'A' + 10) * baseProduct;
            }

            sum += num;
        }
        System.out.println(sum);







    }
}
