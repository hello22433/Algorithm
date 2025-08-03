import java.util.*;

public class Main {
    static class State implements Comparable<State> {
        int x, y, minVal, maxVal;

        State(int x, int y, int minVal, int maxVal) {
            this.x = x;
            this.y = y;
            this.minVal = minVal;
            this.maxVal = maxVal;
        }

        // (max - min) 기준으로 오름차순 정렬
        @Override
        public int compareTo(State o) {
            int diff = (this.maxVal - this.minVal) - (o.maxVal - o.minVal);
            return diff != 0 ? diff : 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                grid[i][j] = sc.nextInt();

        // 방문 체크용: 위치(x,y) + 현재 min값, max값 상태 저장할 공간이 필요
        // 상태 공간이 너무 크므로, min, max 값 범위 제한 또는 해시맵으로도 대체 가능.
        // 여기서는 단순히 dp 배열을 Map으로 구현해본 예시.

        // dx, dy: 오른쪽, 아래 이동만 가능
        int[] dx = {0, 1};
        int[] dy = {1, 0};

        // 우선순위 큐: (max-min) 차이가 작은 상태부터 꺼냄
        PriorityQueue<State> pq = new PriorityQueue<>();
        // 방문 상태 체크용: Map< (x,y,minVal,maxVal), Boolean > 필요 -> 메모리 문제로 실제론 비효율적
        // 여기서는 4차원 배열 대신 HashMap 사용 (간단히 하려면)

        // 방문 체크: key를 문자열로 만들어서 관리
        Set<String> visited = new HashSet<>();

        State start = new State(0,0,grid[0][0],grid[0][0]);
        pq.offer(start);
        visited.add(0 + "," + 0 + "," + grid[0][0] + "," + grid[0][0]);

        while (!pq.isEmpty()) {
            State cur = pq.poll();

            // 목적지 도착 시 차이 출력 후 종료
            if(cur.x == n-1 && cur.y == n-1) {
                System.out.println(cur.maxVal - cur.minVal);
                return;
            }

            for(int dir=0; dir<2; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if(nx < n && ny < n) {
                    int newMin = Math.min(cur.minVal, grid[nx][ny]);
                    int newMax = Math.max(cur.maxVal, grid[nx][ny]);
                    String key = nx + "," + ny + "," + newMin + "," + newMax;

                    if(!visited.contains(key)) {
                        visited.add(key);
                        pq.offer(new State(nx, ny, newMin, newMax));
                    }
                }
            }
        }
    }
}
