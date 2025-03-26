
import java.io.*;
import java.math.BigInteger;
import java.nio.Buffer;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        Set<String> setting = new LinkedHashSet<>();
        for (int i = 0; i < N; i++) {
            setting.add(scanner.next());
        }
        List<String> list = new ArrayList<>(setting);

        Collections.sort(list, (a,b) -> {
            if (a.length() == b.length()) {
                return a.compareTo(b);
            }
            return a.length() - b.length();
        });

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }


}

