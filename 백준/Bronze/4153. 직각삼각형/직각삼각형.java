
import java.io.*;
import java.nio.Buffer;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int[] abc = new int[3];

        while (scanner.hasNextLine()) {
            String[] line = scanner.nextLine().split(" ");
            abc[0] = Integer.parseInt(line[0]);
            abc[1] = Integer.parseInt(line[1]);
            abc[2] = Integer.parseInt(line[2]);
            if (abc[0] == 0 && abc[1] == 0 && abc[2] == 0) {
                break;
            }
            Arrays.sort(abc);
            if (Math.pow(abc[2],2) == Math.pow(abc[0],2) + Math.pow(abc[1],2)) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }
        }
    }
}

//