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

        int n;
        List<Integer> aksoos = new ArrayList<>();
        while (sc.hasNext()) {
            n = sc.nextInt();
            
            if (n == -1) break;

            int sum = 0;

            for (int i = 1; i < n; i++) {
                if (n % i == 0) {
                    aksoos.add(i);
                    sum += i;
                }
            }

            if (sum == n) {
                System.out.printf("%d = ", n);
                for (int i = 0; i < aksoos.size(); i++) {

                    if (i == aksoos.size() - 1) {
                        System.out.printf("%d\n" , aksoos.get(i));
                    } else {
                        System.out.printf("%d + ", aksoos.get(i));
                    }
                }

            } else {
                System.out.printf("%d is NOT perfect.\n", n);
            }

            aksoos.clear();

        }









    }
}
