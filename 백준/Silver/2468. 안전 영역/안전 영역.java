
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] visited;
    static int[][] matrix;

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(st.nextToken());
        matrix = new int[N][N];
        int min = 101;
        int max = 0;

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < N; j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(matrix[i][j], min);
                max = Math.max(max, matrix[i][j]);
            }
        }

        int maxCount = 0;
        for (int i = min-1; i <= max+1; i++){
            visited = new int[N][N];
            int bucketCount = 0;
            for (int j = 0; j < N; j++){
                for (int k = 0; k < N; k++){
                    if (matrix[j][k] > i && visited[j][k] == 0){
                        bfs(i, N, j, k);
                        bucketCount += 1;
                    }
                }
            }
            maxCount = Math.max(maxCount, bucketCount);
        }

        System.out.print(maxCount);
    }

    private static void bfs(int height, int N, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        queue.add(new int[]{x,y});

        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];

            for (int[] dir : directions) {
                int newX = curX + dir[0];
                int newY = curY + dir[1];

                if (newX>=0&&newY>=0&&newX<N&&newY<N
                        && visited[newX][newY]==0
                        && matrix[newX][newY]>height){
                    queue.add(new int[]{newX,newY});
                    visited[newX][newY]=1;
                }
            }
        }
    }
}


// 행렬을 만든다. 가장 작은 값과 가장 큰 값을 저장해놔야 한다.
// 가장 작은 값부터 가장 큰 값까지 반복하며 행렬을 돌린다. 10000 * 100
// 100번의 bfs