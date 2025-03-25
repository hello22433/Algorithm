
import java.io.*;
import java.nio.Buffer;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    static String[] deck;
    static int N;
    static int M;
    static int maxSum = 0;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String[] NM = scanner.nextLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);
        deck = scanner.nextLine().split(" ");

        backtrack(0, 0, 0);
        System.out.println(maxSum);
    }

    private static void backtrack(int count, int sum, int start) {
        if (count ==3) {
            if (sum <= M) {
                maxSum = Math.max(maxSum, sum);
            }
            return;
        }

        for (int i = start; i < deck.length; i++) {
            int deckI = Integer.parseInt(deck[i]);
            if (sum + deckI > M) continue;

            backtrack(count+1, sum+deckI, i + 1);
        }
    }
}

