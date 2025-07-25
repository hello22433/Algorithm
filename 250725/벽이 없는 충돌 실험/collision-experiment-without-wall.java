import java.util.*;

public class Main {
    static int t, n;

    // 동 남 서 북 0 1 2 3
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static HashMap<Integer, Bead> map;
    static HashMap<Integer, Bead> nextMap;
    static final int hashCode = 4001;
    static int lastCrashTime;
    static Queue<int[]> beadXY;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        for (int tc = 0; tc < t; tc++) {
            map = new HashMap<>();
            lastCrashTime = -1;
            beadXY = new LinkedList<>();

            n = sc.nextInt();

            for (int i = 1; i <= n; i++) {
                int num = i;
                int x = (sc.nextInt() + 1000) * 2;
                int y = (sc.nextInt() + 1000) * 2; 
                // int x = sc.nextInt()*2; 
                // int y = sc.nextInt()*2; 
                int w = sc.nextInt();
                char d = sc.next().charAt(0);
                int dir = -1;

                if (d == 'R') dir = 0;
                if (d == 'D') dir = 1;
                if (d == 'L') dir = 2;
                if (d == 'U') dir = 3;

                int key = x * hashCode + y;
                map.put(key, new Bead(num, w, dir));
                beadXY.offer(new int[]{x ,y});
            }

            simulateBeadMoves();
            System.out.println(lastCrashTime);
        }
    }

    public static void simulateBeadMoves() {
        int spentTime = 0;

        while (spentTime < 4001) {
            if (beadXY.isEmpty()) break;
            nextMap = new HashMap<>();

            int qSize = beadXY.size();
            spentTime += 1;

            for (int T = 0; T < qSize; T++) {
                int[] xy = beadXY.poll();
                int x = xy[0];
                int y = xy[1];

                int key = x * hashCode + y;
                Bead bead = map.get(key);
                int dir = bead.dir;
                // System.out.print(key+ " ");

                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || nx > 4000 || ny < 0 || ny > 4000) continue;
                
                int newKey = nx * hashCode + ny;

                if (nextMap.containsKey(newKey)) {
                    lastCrashTime = spentTime;

                    Bead existedBead = nextMap.get(newKey);

                    if (existedBead.w < bead.w) {
                        nextMap.put(newKey, bead);
                    } else if (existedBead.w > bead.w) {
                        //  넣지 않고 넘어감.
                    } else {
                        if (existedBead.num < bead.num) {
                            nextMap.put(newKey, bead);
                        } else {
                            // 넣지 않고 넘어감
                        }
                    }
                } else {
                    nextMap.put(newKey, bead);
                    beadXY.offer(new int[]{nx, ny});
                }
            }
                // System.out.println();

            cloneNextToOne();
        }
    }

    public static void cloneNextToOne() {
        map = new HashMap<>(nextMap);

        // for (String key : nextMap.keySet()) {
        //     map.put(key, nextMap.get(key));
        // }
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

// 2초에 한 칸씩 동일한 속도로 정해진 방향으로 움직임
// 영향력 큰 구슬 하나만 남음 -> 무게 가장 큼 , 무게같으면 -> 구슬 번호 가장 큼
// 충돌은 두 구슬이 이동하는 도중에도 가능

// 가장 마지막 충돌의 시간!
// 

// bead : 넘버, 무게 , 방향


// board : 0 < x <= 2000

// 원래 1초에 하나씩 움직이면 그 결과가 충돌되지 않는 것으로 판단 되었다.
// 하지만? 2초로 늘려서 보자.
// 원래 보드보다 2배가 큰 이동 진행상황 체크 보드를 만든다.
// 이동하는 과정을 체크를 해야 하는 것이다.
// 그럼 두 배가 된 보드에서 원래 위치는 어떻게 반영할 것인가?
// 곱하기 2를 한다.
// 
// 
// 
// 
// 부딪히는 와중에 하나만 남고 삭제되는 것이기에,
// 부딪히는 순간에 처리해주면 시간과 공간을 아낄 수 있다.
// 
