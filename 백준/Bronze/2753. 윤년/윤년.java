
import java.io.BufferedReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();

        if ((a % 4 == 0 && a % 100 != 0) || a % 400 == 0) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}

//