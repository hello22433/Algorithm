
import java.io.BufferedReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // UTC 시간 구하기
        ZonedDateTime utcNow = ZonedDateTime.now(ZoneOffset.UTC);

        // 서울 시간으로 변환(UTC +9)
        ZonedDateTime seoulTime = utcNow.withZoneSameInstant(ZoneId.of("Asia/Seoul"));

        // 날짜를 "YYYY-MM-DD" 형식으로 출력
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println(seoulTime.format(formatter));
    }
}

//