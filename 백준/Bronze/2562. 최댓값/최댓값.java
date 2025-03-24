
import java.io.*;
import java.nio.Buffer;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int answer = 0;
        int idx = -1;
        
        for (int i = 0; i < 9; i++) {
            int n = scanner.nextInt();
            if (n > answer) {
                answer = n;
                idx = i+1;
            }
        }
        
        System.out.println(answer);
        System.out.println(idx);
        
    }
}

//