
import java.io.*;
import java.math.BigInteger;
import java.nio.Buffer;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String[] NN = br.readLine().split(" ");

        Set<String> listN = new HashSet<>();
        for (int i = 0; i < N; i++) {
            listN.add(NN[i]);
        }

        int M = Integer.parseInt(br.readLine());
        String[] MM = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            if (listN.contains(MM[i])) {
                bw.write("1\n");
            } else {
                bw.write("0\n" );
            }
        }
        bw.close();
    }
}

// 정렬 하고 투포인터로 같이 비교한다.
//

