
import java.io.*;
import java.nio.Buffer;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] input = reader.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int X = Integer.parseInt(input[1]);

        input = reader.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            if (Integer.parseInt(input[i]) < X) {
                writer.write(Integer.parseInt(input[i]) + " ");
            }
        }
        writer.close();
    }
}

//