

import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();

        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < A.length(); i++) {
            if ('.' == A.charAt(i)) {
                if (count % 2 != 0) {
                    System.out.print(-1);
                    return;
                }
                sb.append("A".repeat((count / 4) * 4));
                sb.append("B".repeat(count % 4));
                sb.append(".");
                count = 0;
            } else {
                count++;
            }
        }
        
        if (count % 2 != 0) {
            System.out.print(-1);
            return;
        }
        sb.append("A".repeat((count / 4) * 4));
        sb.append("B".repeat(count % 4));
        System.out.print(sb.toString());
    }
}

// X의 개수를 세어본다. 2의 배수이면 덮을 수 있음. 아니라면 덮을 수 없음 => -1 출력하고 리턴
// 하나씩 .이 나올떄까지 탐색하면서 count.
// .이 나오면 count가 2의 배수인지 탐색
// 2의 배수이면 A * 4로 나눈 몫 만큼 sb에 더함.
// B * 나머지 sb에 더함
// 이후 .더함
// count = 0;
// count가 0이고 .이면 그냥 .만 더하고 컨티뉴 -> 굳이 로직 안 짜도 됨
// 마지막에 .로직 수동으로 작동시켜주기 (.이나오지 않을 경우 대비)