
import java.io.*;
import java.nio.Buffer;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            String[] RS = scanner.nextLine().split(" ");
            int R = Integer.parseInt(RS[0]);
            String C = RS[1];
            for (int j = 0; j < C.length(); j++) {
                sb.append(String.valueOf(C.charAt(j)).repeat(R));
            }
            System.out.println(sb);
            sb.setLength(0);
        }

    }
}

//