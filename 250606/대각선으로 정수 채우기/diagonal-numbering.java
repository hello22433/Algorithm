import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 행크기
        int n = sc.nextInt();
        // 열크기
        int m = sc.nextInt();

        int[][] arr1 = new int[n][m];

        int num = 1;
        int imsiJ = 0;
        // 열
        for (int i = 0; i < m; i++) {
            // 행
            int imsiI = i;
            for (int j = imsiJ; j < n; j++) {
                if (imsiI < 0) break;
                arr1[j][imsiI--] = num++;
            }
            
            // 마지막 열에 도달했는데 아직 빈칸이 존재한다면, 열을 그대로 유지해야 한다.
            // 그리고 시작 행을 하나씩 늘려야 한다.
            if (i == m-1 && arr1[n-1][m-1] == 0) {
                i = m-2;
                imsiJ++;
            } else if (i == m-1 && arr1[n-1][m-1] != 0) {
                break;
            }
        }

        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr1[i][j] + " ");
            }
            System.out.println();
        }
    }
}

// 1열씩 증가할 것이고
// 시작은 1행에서 무조건 할 것이고
// 1행이 늘어나고 1열이 줄어든다.