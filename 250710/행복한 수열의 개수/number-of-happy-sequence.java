import java.util.Scanner;
  
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        int happyCnt = 0;
        
        for (int i = 0; i < n; i++) {
            int rowHappyCnt = 1;
            int rowHappyMaxCnt = 1;
            int columnHappyCnt = 1;
            int columnHappyMaxCnt = 1;

            int rowFirstValue = grid[i][0];
            int columnFirstValue = grid[0][i];

            for (int j = 1; j < n; j++) {
                if (grid[i][j] == rowFirstValue) {
                    rowHappyCnt++;
                    rowHappyMaxCnt = Math.max(rowHappyCnt, rowHappyMaxCnt);
                } else {
                    rowFirstValue = grid[i][j];
                    rowHappyCnt = 1;
                }
                
                if (grid[j][i] == columnFirstValue) {
                    columnHappyCnt++;
                    columnHappyMaxCnt = Math.max(columnHappyCnt, columnHappyMaxCnt);
                } else {
                    columnFirstValue = grid[j][i];
                    columnHappyCnt = 1;
                }
            }
            if (rowHappyMaxCnt >= m) happyCnt++;
            if (columnHappyMaxCnt >= m) happyCnt++;
        }
            
        System.out.print(happyCnt);
    }
}


// 행을 순회한다.
// 열을 순회하여 찾는다. 

// 열을 순회한다.
// 행을 순회하여 찾는다.