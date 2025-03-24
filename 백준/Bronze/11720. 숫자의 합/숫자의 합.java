
import java.io.*;
import java.nio.Buffer;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String b = scanner.next();
        int answer = 0;

        for (int i = 0; i < n; i++) {
            answer += Integer.parseInt(String.valueOf(b.charAt(i)));
        }

        System.out.println(answer);
    }
}

//