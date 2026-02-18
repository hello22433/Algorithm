import java.io.*;
import java.util.*;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String[] arr = new String[5];

        for (int i = 0; i < 5; i++) {
            arr[i] = br.readLine();
        }

        StringBuilder sb = new StringBuilder();

        for (int col = 0; col < 15; col++) {
            for (int row = 0; row < 5; row++) {
                if (col < arr[row].length()) {
                    sb.append(arr[row].charAt(col));
                }
            }
        }

        System.out.println(sb);

    }
}
