import java.util.*;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        // 1~50
        int[][] map = new int[51*2][51*2];
        boolean[][] visited = new boolean[51*2][51*2];
        
        for (int i = 0; i < rectangle.length; i++) {
            int leftBottomX = rectangle[i][0]*2;
            int leftBottomY = rectangle[i][1]*2;
            int rightTopX = rectangle[i][2]*2;
            int rightTopY = rectangle[i][3]*2;
            
            for (int j = leftBottomX; j <= rightTopX; j++) {
                for (int k = leftBottomY; k <= rightTopY; k++) {
                    if (j == rightTopX || j == leftBottomX || k == leftBottomY || k == rightTopY) {
                        if (map[j][k] != 2) map[j][k] = 1;
                    } else {
                        map[j][k] = 2;
                    }
                }
            }
        }
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{characterX*2, characterY*2});
        visited[characterX*2][characterY*2] = true;
        
        int[] dx = new int[]{1,-1,0,0};
        int[] dy = new int[]{0,0,1,-1};
        
        int distance = 0;
        while (!q.isEmpty()) {
            int qSize = q.size();
            
            for (int t = 0; t < qSize; t++) {
                int[] poller = q.poll();
                int x = poller[0];
                int y = poller[1];
                
                if (x == itemX*2 && y == itemY*2) return distance/2;
                
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    
                    if (nx >= 1 && nx < 102 && ny >= 1 && ny < 102 && map[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
            distance++;
        }
        
        return -1;
    }
}

// 2차원 배열을 만든다.
// 길을 만든다.
// 