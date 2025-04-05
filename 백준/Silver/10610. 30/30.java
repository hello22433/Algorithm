

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String N = st.nextToken();

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        boolean zeroBoolean = false;
        String result = "";
        for (char n : N.toCharArray()) {
            if (zeroBoolean) {
                result += n;
                pq.add(Integer.parseInt(String.valueOf(n)));
            } else if (!zeroBoolean && n == '0'){
                zeroBoolean = true;
            } else {
                result += n;
                pq.add(Integer.parseInt(String.valueOf(n)));
            }
        }

        String result2 = "";
        int sum = 0;
        boolean threeRemain = false;
        while (!pq.isEmpty()) {
            int poller = pq.poll();
            result2 += String.valueOf(poller);
            sum += poller;
        }

        if (zeroBoolean && sum % 3 == 0) {
            threeRemain = true;
        }

        result2 += '0';
        if (threeRemain) {
            System.out.print(result2);
        } else {
            System.out.print(-1);
        }

    }
}

// 30의 배수가 되기 위한 방법
// 1. 끝이 0이어야 함.
// 2. 30으로 나누었을 때 나머지가 0이어야 함.
// 숫자들을 더한다.
// false이고 0이면 true로 만든다. 이때 0은 더하지 않고 추가하지 않고 넘어간다.
// 아니면 숫자로 바꿔서 그냥 더한다. 동시에 우선순위큐에 넣는다.
// 우선순위 큐에서 하나씩 빼면서 이어붙인다.
// true이고 sum값을 3으로 나눴을 때 나머지가 0이면 이어붙인 값을 출력한다.
// else -1 리턴