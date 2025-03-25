
import java.io.*;
import java.nio.Buffer;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        scanner.nextLine();
        String[] record = scanner.nextLine().split(" ");
        double[] recorddouble = new double[N];
        for (int i = 0; i < N; i++) {
            recorddouble[i] = Double.parseDouble(record[i]);
        }
        Arrays.sort(recorddouble);
        double sum = 0;

        for (int i = 0; i < N; i++) {
            sum += recorddouble[i] / recorddouble[recorddouble.length -1] * 100;
        }

        System.out.print(sum / (double) N);
    }
}

