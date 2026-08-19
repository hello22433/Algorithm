import java.util.*;

class Solution {
    // 동 남 서 북
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    
    public int solution(int[][] game_board, int[][] table) {
        
        int fulfill = 0;
        
        int[][][] needPieces = getPieces(game_board, 0);
        int[][][] gotPieces = getPieces(table, 1);
        boolean[] usedGotPieces = new boolean[gotPieces.length];
                        System.out.println(Arrays.deepToString(needPieces));
        
        outer : for (int[][] needPiece : needPieces) {
            inner : for (int a = 0; a < gotPieces.length; a++) {
                int[][] gotPiece = gotPieces[a];
                if (usedGotPieces[a]) continue;
                ininner : for (int i = 0; i < 4; i++) {
                    if (checkMatch(needPiece, rotate(gotPiece, i))) {
                        usedGotPieces[a] = true;
                        fulfill += needPiece.length;
                        break inner;
                    }
                }
            }
        }
        
        return fulfill;
    }
    
    private boolean checkMatch(int[][] piece1, int[][] piece2) {
        Arrays.sort(piece1, (a,b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0]-b[0];
        });
        Arrays.sort(piece2, (a,b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0]-b[0];
        });
        if (piece1.length != piece2.length) return false; 
        for (int i = 0; i < piece1.length; i++) {
            if (piece1[i][0] != piece2[i][0] || piece1[i][1] != piece2[i][1]) return false;
        }
        
        return true;
    }
    
    private int[][] rotate(int[][] piece, int repeat) {
        int[][] copyedPiece = new int[piece.length][];
        for (int i = 0; i < copyedPiece.length; i++) {
            copyedPiece[i] = piece[i].clone();
        }
        
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        for (int[] p : copyedPiece) {
            int x = p[0];
            int y = p[1];
            
            for (int i = 0; i < repeat; i++) {
                int tmp = x;
                x = y;
                y = -tmp;
            }
            
            p[0] = x;
            p[1] = y;
            minX = Math.min(minX, p[0]);
            minY = Math.min(minY, p[1]);
        }
        
        for (int[] p : copyedPiece) {
            p[0] = normalize(minX, p[0]);
            p[1] = normalize(minY, p[1]);
        }
        
        return copyedPiece;
    }
    
    private int[][][] getPieces(int[][] board, int targetValue) {
        
        boolean[][] visited = new boolean[board.length][board[0].length];
        
        List<int[][]> pieces = new ArrayList<>();
        
        outer : for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == targetValue && !visited[i][j]) {
                    pieces.add(getPiece(board, targetValue, visited, i, j));
                }
            }
        }
        
        return pieces.toArray(new int[pieces.size()][][]);
    }
    
    private int[][] getPiece(int[][] board, int targetValue, boolean[][] visited, int x, int y) {
        List<int[]> piece = new ArrayList<>();
        
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;
        piece.add(new int[]{x, y});
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];
            
            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                
                if (nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length && board[nx][ny] == targetValue && !visited[nx][ny]) {
                    q.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    piece.add(new int[]{nx, ny});
                }
            }
        }
         
        int minX = piece.get(0)[0];
        int minY = piece.get(0)[1];
        for (int[] p : piece) {
            minX = Math.min(minX, p[0]);
            minY = Math.min(minY, p[1]);
        }
        
        for (int[] p : piece) {
            p[0] = normalize(minX, p[0]);
            p[1] = normalize(minY, p[1]);
        }
        
        return piece.toArray(new int[piece.size()][]);
    }
    
    private int normalize(int minVal, int val) {
        return val - minVal;
    }
}

// 조각들을 모두 뽑아낸다
// 뽑아낸 조각들을 모두 0,0에 딱 붙인다 (x최솟값, y최솟값 빼기)
// 