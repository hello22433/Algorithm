import java.io.*;
import java.util.*;

public class Main {
    static int t, n;

    // 동 남 서 북 0 1 2 3
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static HashMap<String, Bead> map;
    static HashMap<String, Bead> nextMap;
    static int lastCrashTime;
    static Queue<int[]> beadXY;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {
            map = new HashMap<>();
            lastCrashTime = -1;
            beadXY = new LinkedList<>();

            n = Integer.parseInt(br.readLine());

            for (int i = 1; i <= n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = (Integer.parseInt(st.nextToken()) + 1000) * 2;
                int y = (Integer.parseInt(st.nextToken()) + 1000) * 2;
                int w = Integer.parseInt(st.nextToken());
                char d = st.nextToken().charAt(0);

                int dir = -1;
                if (d == 'R') dir = 0;
                else if (d == 'D') dir = 1;
                else if (d == 'L') dir = 2;
                else if (d == 'U') dir = 3;

                String key = x + "," + y;
                map.put(key, new Bead(i, w, dir));
                beadXY.offer(new int[]{x, y});
            }

            simulateBeadMoves();
            output.append(lastCrashTime).append("\n");
        }

        System.out.print(output);
    }

    public static void simulateBeadMoves() {
        int spentTime = 0;

        while (spentTime < 4001 && !beadXY.isEmpty()) {
            nextMap = new HashMap<>();
            int qSize = beadXY.size();
            spentTime++;

            for (int i = 0; i < qSize; i++) {
                int[] xy = beadXY.poll();
                int x = xy[0], y = xy[1];
                String key = x + "," + y;
                Bead bead = map.get(key);
                if (bead == null) continue;

                int dir = bead.dir;
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || nx > 4000 || ny < 0 || ny > 4000) continue;

                String newKey = nx + "," + ny;

                if (nextMap.containsKey(newKey)) {
                    lastCrashTime = spentTime;
                    Bead existing = nextMap.get(newKey);
                    if (existing.w < bead.w) {
                        nextMap.put(newKey, bead);
                    } else if (existing.w == bead.w && existing.num < bead.num) {
                        nextMap.put(newKey, bead);
                    }
                } else {
                    nextMap.put(newKey, bead);
                    beadXY.offer(new int[]{nx, ny});
                }
            }

            map = new HashMap<>(nextMap);
        }
    }
}

class Bead {
    int num;
    int w;
    int dir;

    Bead(int num, int w, int dir) {
        this.num = num;
        this.w = w;
        this.dir = dir;
    }
}
