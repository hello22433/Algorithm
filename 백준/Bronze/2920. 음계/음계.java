import java.io.*;
import java.util.*;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[8];

        for (int i = 0; i < 8; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < 8; i++) {
            if (Math.abs(arr[i] - arr[i-1]) != 1) {
                System.out.print("mixed");
                return;
            }
        }


        if (arr[0] == 1) {
            System.out.println("ascending");
        } else {
            System.out.println("descending");
        }


    }


}
