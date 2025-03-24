
import java.io.*;
import java.nio.Buffer;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= 30; i++) {
            list.add(i);
        }

        for (int i =1; i <= 28; i++) {
            list.remove(Integer.valueOf(scanner.nextInt()));
        }


        System.out.println(list.get(0));
        System.out.println(list.get(1));
    }
}

//