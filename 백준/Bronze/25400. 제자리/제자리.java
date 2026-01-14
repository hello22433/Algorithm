import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        int cnt = 0;
        int curNum = 1;
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            q.add(Integer.parseInt(st.nextToken()));
        }

        while (!q.isEmpty()) {
            int num = q.poll();

            if (num == curNum) {
                curNum += 1;
            } else {
                cnt++;
            }
        }
        System.out.print(cnt);


    }
}