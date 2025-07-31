import java.util.*;
public class Main {
    static int n,h,m;
    static int[][] grid;
    static boolean[][] visited;
    static int[][] recordMovesGrid;
    static int[][] step;
    static int[][] menXY;

    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        h = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][n];
        menXY = new int[h][2];
        recordMovesGrid = new int[n][n];

        int menXYIdx = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                
                grid[i][j] = sc.nextInt();

                if (grid[i][j] == 2) {
                    menXY[menXYIdx][0] = i;
                    menXY[menXYIdx++][1] = j;
                }
            }
        // Please write your code here.

        for (int i = 0; i < h; i++) {
            visited = new boolean[n][n];
            step = new int[n][n];
            int x = menXY[i][0];
            int y = menXY[i][1];
            int moves = bfs(x, y);
            recordMovesGrid[x][y] = moves;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) { 
                System.out.print(recordMovesGrid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void pushStep(int x, int y, int nextStep) {
        step[x][y] = nextStep;
    }

    public static boolean inbound(int x ,int y) {
        return x >= 0 && x < n && y >=0 && y < n;
    }

    public static boolean canGo(int x, int y) {
        return inbound(x,y) && grid[x][y] != 1;
    }

    public static int bfs(int x, int y) {

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        step[x][y] = 0;
        visited[x][y] = true;
        
        while (!q.isEmpty()) {
            int[] poller = q.poll();
            int curX = poller[0];
            int curY = poller[1];

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (canGo(nx,ny) && !visited[nx][ny]) {
                    q.add(new int[]{nx,ny});
                    pushStep(nx,ny,step[curX][curY] + 1);
                    visited[nx][ny] = true;

                    if (grid[nx][ny] == 3) return step[nx][ny]; 
                }
            }
        }

        return -1;
    }

    
}

// 0 1 2 3 으로만..
// N N
// H명이 겹치지 않게 서있음
// 비를 피할 수 있는 공간의 위치 M개
// 각 사람마다 비를 피할 수 있는 가장 가까운 공간까지의 거리

// 0 : 이동가능
// 1 : 벽이 있음
// 2 : 사람 있음
// 3 : 비를 피할 수 있음
// 이동에 1초 소요

// 각 사람마다 움직여서, 3에 도착하면 이동거리를 리턴한다.
// 3과 1이 아니면 이동하고, 3이면 지금껏 이동한 거리에 1을 더해서 리턴한다.