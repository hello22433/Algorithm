import java.util.*;

class Solution {
    
    int[][] maps;
    boolean[][] visited;
    int[] dx = {0,1,0,-1};
    int[] dy = {1,0,-1,0};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        
        // 맵은, 가장 왼쪽 하단 부터 가장 오른쪽 상단까지 모두 포함해야한다. 즉, 가장 낮은 지점, 가장 왼쪽지점, 가장 오른쪽지점, 가장 위쪽 지점을 모두 보장해야한다.
        
        int minX = rectangle[0][0]*2;
        int minY = rectangle[0][1]*2;
        int maxX = rectangle[0][2]*2;
        int maxY = rectangle[0][3]*2;
        
        for (int i = 0; i < rectangle.length; i++) {
            minX = Math.min(minX, rectangle[i][0]*2);
            minY = Math.min(minY, rectangle[i][1]*2);
            maxX = Math.max(maxX, rectangle[i][2]*2);
            maxY = Math.max(maxY, rectangle[i][3]*2);
        }
        
        maps = new int[maxX*2+1][maxY*2+1];
        visited = new boolean[maxX*2+1][maxY*2+1];
        
        // 다덮어버리고 가장 바깥쪽 테두리만 남긴다.
        // 
        for (int i = 0; i < rectangle.length; i++) {
            
            
            
            // 테두리만 2
            // 좌측상단 -> 우측 상단
            for (int j = rectangle[i][1]*2; j <= rectangle[i][3]*2; j++) {
                if (maps[rectangle[i][2]*2][j] != 1)
                    maps[rectangle[i][2]*2][j] = 2;
            }
            // 좌측하단 -> 좌측상단
            for (int j = rectangle[i][0]*2; j <= rectangle[i][2]*2; j++) {
                if (maps[j][rectangle[i][1]*2] != 1)
                    maps[j][rectangle[i][1]*2] = 2;
            }
            // 우측하단 -> 우측상단
            for (int j = rectangle[i][0]*2; j <= rectangle[i][2]*2; j++) {
                if (maps[j][rectangle[i][3]*2] != 1)
                    maps[j][rectangle[i][3]*2] = 2;
            }
            // 좌측하단 -> 우측하단
            // 
            for (int j = rectangle[i][1]*2; j <= rectangle[i][3]*2; j++) {
                if (maps[rectangle[i][0]*2][j] != 1)
                    maps[rectangle[i][0]*2][j] = 2;
            }
            
            for (int j = rectangle[i][0]*2+1; j < rectangle[i][2]*2; j++) {
                for (int k = rectangle[i][1]*2+1; k < rectangle[i][3]*2; k++) {
                    maps[j][k] = 1;
                }
            }
        }
        return bfs(maxX, maxY, rectangle, characterX*2, characterY*2, itemX*2, itemY*2) / 2;
        
    }
    
    private int bfs(int maxX, int maxY, int[][] rectangle, int x, int y, int itemX, int itemY) {
        
        Deque<int[]> q = new ArrayDeque<>();
        visited[x][y] = true;
        q.offer(new int[]{x, y, 0});
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];
            int moves = cur[2];
            // System.out.println(curX + " " + curY);
            
            if (curX == itemX && curY == itemY) return moves;
            
            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                
                if (nx >= 0 && nx <= maxX && ny >= 0 && ny <= maxY && !visited[nx][ny] && maps[nx][ny] == 2) { // 겹쳐진 곳이긴한데, 거기가 꼭짓점이면 예외로 한다.
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny, moves+1});
                }
            }
        }
        
        return -1;
    }
}

// 좌표맵을 값을 0으로 한 번 만들고, 테두리를 1씩 더한다.
// 캐릭터는 변이 있되, 가장 안 겹쳐진 곳으로 돌아다닌다.
// 