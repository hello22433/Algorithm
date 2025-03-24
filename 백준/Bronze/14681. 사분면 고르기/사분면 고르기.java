
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
        int b = scanner.nextInt();
        
        if (a > 0 && b > 0) {
            System.out.println(1);
        } else if (a > 0 && b < 0) {
            System.out.println(4);
        } else if (a < 0 && b < 0) {
            System.out.println(3);
        } else {
            System.out.println(2);
        }
    }
}

//