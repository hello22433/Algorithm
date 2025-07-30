import java.util.*;


public class Main {

    static int n;
    static int[][] grid;
    static int villiagesCnt = 0;
    static boolean[][] visited;
    static List<Integer> menCnt = new ArrayList<>();

    // 동 남 서 북 0 1 2 3 
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
                
        // Please write your code here.

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j]==1 && !visited[i][j]) {
                    villiagesCnt++;
                    visited[i][j] = true;
                    int people = dfs(i,j);
                    menCnt.add(people);
                }
            }
        }
        Collections.sort(menCnt, (a,b) -> a-b);

        System.out.println(villiagesCnt);
        for (int i = 0; i < menCnt.size(); i++) {
            System.out.println(menCnt.get(i));
        }
    }

    public static boolean inbound(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public static boolean canGo(int x, int y) {
        if (inbound(x, y) && grid[x][y] == 1) return true;

        return false;
    }

    public static int dfs(int x, int y) {
        int people = 1;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (canGo(nx,ny) && !visited[nx][ny]) {
                visited[nx][ny] = true;
                people += dfs(nx,ny);
            }
        }

        return people;
    }
}


// n n
// 
// 만약 마지막 노드의 마지막 반복이라면, 더이상 이어진 마을이 없다는 의미이므로 사람 수를 리턴한다.