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

        for (int i = 1; i <= 2*n-1; i++) {
            int dist = Math.abs(n-i);

            for (int j = 0; j < n - (dist+1); j++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= 2*(dist+1)-1; j++) {
                System.out.print("*");
            }

            System.out.println();
        }






    }
}
