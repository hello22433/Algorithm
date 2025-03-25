
import java.io.*;
import java.nio.Buffer;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        String[] ab = scanner.nextLine().split(" ");
        long A = Integer.parseInt(ab[0]);
        long B = Integer.parseInt(ab[1]);
        System.out.print((A+B)*(A-B));
    }
}

// 티셔츠, 연필 모두 최소를 맞춰야 한다. 연필은 7로 나눈 몫 + 나머지
// 티셔츠는 각각에 대해 나누고 몫 + 나머지가0이아니라면 +1