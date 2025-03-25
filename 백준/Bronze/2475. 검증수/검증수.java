
import java.io.*;
import java.nio.Buffer;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        long pow = 0;
        
        for (int i = 0; i < s.length; i++) {
            int si = Integer.parseInt(s[i]);
            pow += (long) Math.pow(si, 2);
        }
        
        System.out.print(pow%10);
    }
}

// 티셔츠, 연필 모두 최소를 맞춰야 한다. 연필은 7로 나눈 몫 + 나머지
// 티셔츠는 각각에 대해 나누고 몫 + 나머지가0이아니라면 +1