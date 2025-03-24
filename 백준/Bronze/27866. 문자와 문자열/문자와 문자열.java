
import java.io.*;
import java.nio.Buffer;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String c = scanner.next();
        int n = scanner.nextInt();

        System.out.println(c.charAt(n-1));

    }
}

//