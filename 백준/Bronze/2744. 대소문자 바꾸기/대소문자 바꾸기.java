
import java.io.*;
import java.nio.Buffer;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        StringBuilder sb = new StringBuilder();
        
        for (char c : a.toCharArray()) {
            if (String.valueOf(c).equals(String.valueOf(c).toUpperCase())) {
                sb.append(String.valueOf(c).toLowerCase());
            } else {
                sb.append(String.valueOf(c).toUpperCase());
            }
        }
        
        System.out.println(sb.toString());

    }
}

// 티셔츠, 연필 모두 최소를 맞춰야 한다. 연필은 7로 나눈 몫 + 나머지
// 티셔츠는 각각에 대해 나누고 몫 + 나머지가0이아니라면 +1