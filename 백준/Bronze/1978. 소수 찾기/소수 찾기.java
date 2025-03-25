
import java.io.*;
import java.nio.Buffer;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        String[] s = scanner.nextLine().split(" ");
        int count = 0;

        for (int i = 0; i < N; i++) {
            int si = Integer.parseInt(s[i]);
            if (isSosoo(si)) {
                count += 1;
            }
        }
        System.out.println(count);
    }

    private static boolean isSosoo(int si) {
        if (si == 1) {
            return false;
        }
        
        for (int i = 2; i < si; i++) {
            if (si % i == 0) {
                return false;
            }
        }

        return true;
    }
}

// 티셔츠, 연필 모두 최소를 맞춰야 한다. 연필은 7로 나눈 몫 + 나머지
// 티셔츠는 각각에 대해 나누고 몫 + 나머지가0이아니라면 +1