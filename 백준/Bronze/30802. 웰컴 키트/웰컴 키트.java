
import java.io.*;
import java.nio.Buffer;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        ArrayList<Integer> TshirtsArr = new ArrayList<>();

        String[] T_shirts = scanner.nextLine().split(" ");
        int Tsum = 0;
        int idx = 0;
        while (Tsum != N) {
            Tsum += Integer.parseInt(T_shirts[idx]);
            TshirtsArr.add(Integer.parseInt(T_shirts[idx]));
            idx++;
        }

        String[] TP = scanner.nextLine().split(" ");
        int T = Integer.parseInt(TP[0]);
        int P = Integer.parseInt(TP[1]);

        int TshirtsCount = 0;
        for (Integer i : TshirtsArr) {
            if (i%T != 0) {
                TshirtsCount += i/T + 1;
            } else {
                TshirtsCount += i/T;
            }
        }
        System.out.println(TshirtsCount);
        System.out.print(N/P + " " + N%P);


    }
}

// 티셔츠, 연필 모두 최소를 맞춰야 한다. 연필은 7로 나눈 몫 + 나머지
// 티셔츠는 각각에 대해 나누고 몫 + 나머지가0이아니라면 +1