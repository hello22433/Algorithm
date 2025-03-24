
import java.io.*;
import java.nio.Buffer;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        String[] input = sc.nextLine().split(" ");
        int v = Integer.parseInt(sc.nextLine());
        int count = 0;
        
        for (int i = 0; i < N; i++) {
            if (Integer.parseInt(input[i]) == v) {
                count++;
            }
        }
        System.out.println(count);
    }
}

//