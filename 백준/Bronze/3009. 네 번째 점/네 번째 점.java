import java.io.*;
import java.util.*;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int e = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());

        int g = -1;
        int h = -1;

        Map<Integer, Integer> map = new HashMap<>();

        map.put(a, map.getOrDefault(a, 0) + 1);
        map.put(c, map.getOrDefault(c, 0) + 1);
        map.put(e, map.getOrDefault(e, 0) + 1);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                g = entry.getKey();
            }
        }

        map = new HashMap<>();
        map.put(b, map.getOrDefault(b, 0) + 1);
        map.put(d, map.getOrDefault(d, 0) + 1);
        map.put(f, map.getOrDefault(f, 0) + 1);

        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                h = entry.getKey();
            }
        }

        System.out.print(g + " " + h);

    }
}
