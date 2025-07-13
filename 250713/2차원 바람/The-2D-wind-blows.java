import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();
        int[][] averMap = new int[n][m];

        int[][] building = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                building[i][j] = sc.nextInt();
                averMap[i][j] = building[i][j];
            }

        int[][] queries = new int[q][4];
        for (int i = 0; i < q; i++) {
            for (int j = 0; j < 4; j++) {
                queries[i][j] = sc.nextInt();
                queries[i][j]--;
            }
        }

        for (int i = 0; i < q; i++) {

            

            int startXIdx = queries[i][0];
            int startYIdx = queries[i][1];
            int endXIdx = queries[i][2];
            int endYIdx = queries[i][3];
            
            // 겉 부분을 시계방향으로 돌려야 함
            // 위오른쪽아래왼쪽을 순서대로 1234로 칭함
            // 일렬로 세워서 오른쪽으로 밀고 다시 넣는다.
            // endYIdx - startYIdx + 1 + endXIdx - startXIdx + 0 가 길이
            // startXIdx의 startYIdx ~ endYIdx 까지 돌면서 배열에 넣는다. 
            // endYIdx의 startXIdx+1부터 endXIdx-1까지 넣는다.
            // endXIdx의 endYIdx부터 startYIdx까지 넣는다.
            // startYIdx의 endXIdx+1부터 startXIdx-1까지 
            // 오른쪽으로 민다.
            // 반대로 껍데기에 배열을 넣는다. 

            int lastValX = building[startXIdx][endYIdx];
            for (int a = endYIdx; a > startYIdx; a--) {
                building[startXIdx][a] = building[startXIdx][a-1];
                averMap[startXIdx][a] = averMap[startXIdx][a-1];
            }
            building[startXIdx][startYIdx] = building[startXIdx+1][startYIdx];
            averMap[startXIdx][startYIdx] = averMap[startXIdx+1][startYIdx];

            int lastValY = building[endXIdx][endYIdx];
            for (int a = endXIdx; a > startXIdx+1; a--) {
                building[a][endYIdx] = building[a-1][endYIdx];
                averMap[a][endYIdx] = averMap[a-1][endYIdx];
            }
            building[startXIdx+1][endYIdx] = lastValX;
            averMap[startXIdx+1][endYIdx] = lastValX;

            lastValX = building[endXIdx][startYIdx];
            for (int a = startYIdx; a < endYIdx-1; a++) {
                building[endXIdx][a] = building[endXIdx][a+1];
                averMap[endXIdx][a] = averMap[endXIdx][a+1];
            }
            building[endXIdx][endYIdx-1] = lastValY;
            averMap[endXIdx][endYIdx-1] = lastValY;

            building[endXIdx-1][startYIdx] = lastValX;
            for (int a = startXIdx+1; a < endXIdx-1; a++) {
                building[a][startYIdx] = building[a+1][startYIdx];
                averMap[a][startYIdx] = averMap[a+1][startYIdx];
            }


            for (int a = startXIdx; a <= endXIdx; a++) {
                for (int b = startYIdx; b <= endYIdx; b++) {
                    
                    int sum = building[a][b];
                    int count = 1;
                    if (a+1 >= 0 && a+1 < n) {
                        sum += building[a+1][b]; // 아래
                        count++;
                    }
                    if (b-1 >= 0 && b-1 < m) {
                        sum += building[a][b-1]; // 왼쪽
                        count++;
                    }
                    if (a-1 >= 0 && a-1 < n) {
                        sum += building[a-1][b]; // 위
                        count++;
                    }
                    if (b+1 >= 0 && b+1 < m) {
                        sum += building[a][b+1]; // 오른쪽
                        count++;
                    }

                    averMap[a][b] = sum / count;
                }
            }

            for (int a = startXIdx; a <= endXIdx; a++) {
                for (int b = startYIdx; b <= endYIdx; b++) {
                    building[a][b] = averMap[a][b];
                }
            }
        }
            

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(building[i][j] + " ");
            }
            System.out.println();
        }
        
    }
}


// 평균을 저장하는 맵을 하나 만들어 놓는다.
// 네모의 각 부분을 탐색하면서, 인접한 부분의 평균을, 맵에 저장해놓는다.
// 이후 , 원래 맵에 평균을 넣는다.