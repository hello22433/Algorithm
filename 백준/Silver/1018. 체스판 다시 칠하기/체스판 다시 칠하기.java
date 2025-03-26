
import java.io.*;
import java.math.BigInteger;
import java.nio.Buffer;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        char[][] board = new char[N][M];

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i <= N-8; i++) {
            for (int j = 0; j <= M-8; j++) {
                minValue = Math.min(minValue, checkMin(board, i, j));
            }
        }

        System.out.print(minValue);
    }

    private static int checkMin(char[][] board, int x, int y) {
        int startWhite = 0;
        int startBlack = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                int currentColor = board[x + i][y + j];

                // 시작하는 수와 같으려면 i + j가 짝수여야 한다.
                if ((i+j) % 2 ==0) {
                    if (currentColor != 'W') {startWhite++;} // 시작이 화이트인 경우
                    if (currentColor != 'B') {startBlack++;} // 시작이 블랙인 경우
                } else {
                    if (currentColor != 'B') {startWhite++;} // 시작이 화이트인 경우
                    if (currentColor != 'W') {startBlack++;} // 시작이 블랙인 경우
                }
                // 시작하는 수와 다르려면 i + j가 홀수여야 한다.
            }
        }

        return Math.min(startWhite, startBlack);
    }


}

