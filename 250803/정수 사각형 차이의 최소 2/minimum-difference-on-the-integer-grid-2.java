import java.util.*;

public class Main {
    static class State implements Comparable<State> {
        int x, y, minVal, maxVal;

        State(int x, int y, int minVal, int maxVal) {
            this.x = x; this.y = y; this.minVal = minVal; this.maxVal = maxVal;
        }

        @Override
        public int compareTo(State o) {
            return (this.maxVal - this.minVal) - (o.maxVal - o.minVal);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                grid[i][j] = sc.nextInt();

        int[] dx = {0,1};
        int[] dy = {1,0};

        PriorityQueue<State> pq = new PriorityQueue<>();
        // (x,y)에 대해 최소 max-min 차이 저장 배열 (최적화용)
        int[][] dist = new int[n][n];
        for(int i=0;i<n;i++)
            Arrays.fill(dist[i], Integer.MAX_VALUE);

        dist[0][0] = 0;
        pq.offer(new State(0,0,grid[0][0],grid[0][0]));

        while(!pq.isEmpty()){
            State cur = pq.poll();
            int diff = cur.maxVal - cur.minVal;

            // 이미 더 좋은 경로 발견했으면 스킵
            if(dist[cur.x][cur.y] < diff) continue;
            if(cur.x == n-1 && cur.y == n-1){
                System.out.println(diff);
                return;
            }

            for(int dir=0; dir<2; dir++){
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if(nx < n && ny < n){
                    int newMin = Math.min(cur.minVal, grid[nx][ny]);
                    int newMax = Math.max(cur.maxVal, grid[nx][ny]);
                    int newDiff = newMax - newMin;

                    if(dist[nx][ny] > newDiff){
                        dist[nx][ny] = newDiff;
                        pq.offer(new State(nx, ny, newMin, newMax));
                    }
                }
            }
        }
    }
}
