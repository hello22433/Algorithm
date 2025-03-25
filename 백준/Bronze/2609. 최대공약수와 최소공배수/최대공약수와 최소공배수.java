
import java.io.*;
import java.nio.Buffer;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int max = 0;
        for (int i = 1; i <= a && i <= b; i++) {
            if (a%i == 0 && b%i == 0) {
                max = i;
            }
        }

        int min = (a*b)/max;

        System.out.println(max);
        System.out.print(min);
        

    }
}

