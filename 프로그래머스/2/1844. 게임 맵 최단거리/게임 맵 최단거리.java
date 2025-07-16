import java.util.*;

class Solution {
    
    public int solution(int[][] maps) {
        // 최대한 빨리 도착
        // nxm 0 0 에서 출발하여 n-1 m-1 로 이동
        // 최단 도착 시, 지나는 칸의 개수
        // 도착할 수 없으면 -1
        // 0벽 1노벽
        
        int answer = 0;
        
        int n = maps.length;
        int m = maps[0].length;
        int[] xDirection = new int[]{1,-1,0,0};
        int[] yDirection = new int[]{0,0,1,-1};
        boolean[][] visited = new boolean[n][m];
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        visited[0][0] = true;
        int distance = 1;
        
        while (!q.isEmpty()) {
            
            int qSize = q.size();
            
            for (int t = 0; t < qSize; t++) {
                int[] poller = q.poll();
                int x = poller[0];
                int y = poller[1];
                
                if (x == n-1 && y == m-1) return distance;
                
                for (int i = 0; i < 4; i++) {
                    int dx = x + xDirection[i];
                    int dy = y + yDirection[i];
                    
                    if (dx >= 0 && dx < n && dy >= 0 && dy < m && !visited[dx][dy] && maps[dx][dy] == 1) {
                        q.add(new int[]{dx, dy});
                        visited[dx][dy] = true;
                    }
                }
            }
            
            distance++;
        }
        
        return -1;
        
        
        
        
//         int answer = 0;
        
//         int n = maps.length;
//         int m = maps[0].length;
        
//         boolean[][] visited = new boolean[n][m];
//         visited[0][0] = true;
        
//         Queue<int[]> queue = new LinkedList<>();
        
//         queue.offer(new int[]{0,0});
//         int distance = 1;
        
//         int[] x = {1, -1, 0, 0};
//         int[] y = {0, 0, 1, -1};
        
//         while(!queue.isEmpty()) {
//             int size = queue.size();
            
//             for (int i = 0; i < size; i++) {
//                 int[] current = queue.poll();

//                 int curx = current[0];
//                 int cury = current[1];

//                 if (curx == n-1 && cury == m-1) {
//                     return distance;
//                 } 

//                 for (int j = 0; j < 4; j++) {
//                     int nx = curx + x[j];
//                     int ny = cury + y[j];

//                     if (nx>=0 && nx<n && ny>=0 && ny<m && !visited[nx][ny] && maps[nx][ny] == 1) {
//                         visited[nx][ny] = true;
//                         queue.offer(new int[]{nx, ny});
//                     }
//                 }
//             }
//             distance++;
            
//         }
        
//         return -1;
    }
}


// BFS로 풀자.
// n = maps.length, m = maps[0].length
// '맵의 방문 여부'를 표시하는 배열이 필요. 되돌아가는 일 없게. -> 맵 크기(n, m)로 배열 생성하여 모두 false. 
// '현재위치'를 표시할 큐가 필요. (0,0)넣음.
// '방향배열 x좌표 y좌표'설정 (동서남북)

// 큐에서 하나씩 빼면서 더이상 요소가 없을 때까지 함. (이 경우는 모든 경우가 막혀서 못 갔을 경우.)
// 만약 현재위치가 n-1, m-1라면 이동거리를 리턴. 초기값 1
// '움직임' 구현 : '새로운x, y 좌표' 설정 = 현재위치+방향배열 (BFS 탐색). 
// 맵의범위를 넘어가지 않고(nx>=0; nx<m; ny>=0; ny<n;) 방문한곳이 아니고(visited[nx][ny] == true) 막혀있으면 안됨(maps[nx][ny] == 1) 만약 가게 된다면 distance++; 현재위치큐에 현재위치 new int[]{nx, ny} offer. 