import java.util.*;

class Bead {
    int w, d, id, x, y;

    public Bead(int w, int d, int id, int x, int y) {
        this.w = w;
        this.d = d;
        this.id = id;
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static final int OFFSET = 2000;
    static final int LIMIT = 4000;
    static final int[] dx = {1, 0, -1, 0}; // 우하좌상
    static final int[] dy = {0, -1, 0, 1};
    static Map<Integer, Bead> curr = new HashMap<>();
    static Map<Integer, Bead> next = new HashMap<>();
    static List<Bead> list = new ArrayList<>();
    static int t, n, time, lastCrash;
    static int[] dirMap = new int[128];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        dirMap['R'] = 0;
        dirMap['D'] = 1;
        dirMap['L'] = 2;
        dirMap['U'] = 3;

        t = sc.nextInt();
        while (t-- > 0) {
            curr.clear();
            next.clear();
            list.clear();
            lastCrash = -1;
            n = sc.nextInt();

            for (int i = 1; i <= n; i++) {
                int x = sc.nextInt() * 2 + OFFSET;
                int y = sc.nextInt() * 2 + OFFSET;
                int w = sc.nextInt();
                char d = sc.next().charAt(0);
                int dir = dirMap[d];

                Bead b = new Bead(w, dir, i, x, y);
                int key = x * 10000 + y;
                curr.put(key, b);
            }

            for (time = 1; time <= LIMIT; time++) {
                list.clear();
                list.addAll(curr.values());
                curr.clear();
                next.clear();

                for (Bead b : list) {
                    int nx = b.x + dx[b.d];
                    int ny = b.y + dy[b.d];

                    if (nx < 0 || nx > LIMIT || ny < 0 || ny > LIMIT) continue;

                    int key = nx * 10000 + ny;
                    if (!next.containsKey(key)) {
                        next.put(key, new Bead(b.w, b.d, b.id, nx, ny));
                    } else {
                        Bead ex = next.get(key);
                        lastCrash = time;

                        // 우선순위 결정 (무게 → 번호)
                        if (ex.w < b.w || (ex.w == b.w && ex.id < b.id)) {
                            next.put(key, new Bead(b.w, b.d, b.id, nx, ny));
                        }
                    }
                }

                if (next.isEmpty()) break;

                curr.putAll(next);
            }

            System.out.println(lastCrash);
        }
    }
}
