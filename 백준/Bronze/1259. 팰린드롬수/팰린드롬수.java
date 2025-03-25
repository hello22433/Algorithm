
import java.io.*;
import java.nio.Buffer;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            if (s.equals("0")) break;

            if (new StringBuilder(s).reverse().toString().equals(s)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }


    }
}

