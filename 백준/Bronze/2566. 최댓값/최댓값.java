import java.io.*;
import java.util.*;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] arr = new int[10][10];
        int maxVal = -1;
        int maxX = -1, maxY = -1;

        for (int i = 1; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < 10; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if (arr[i][j] > maxVal) {
                    maxVal = arr[i][j];
                    maxX = i;
                    maxY = j;
                }
            }
        }

        System.out.println(maxVal);
        System.out.println(maxX + " " + maxY);



    }
}
