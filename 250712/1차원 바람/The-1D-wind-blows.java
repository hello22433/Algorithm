import java.util.Scanner;

public class Main {
    static int[][] a;
    static int n, m;
    static boolean[] visitedN;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int q = sc.nextInt();
        visitedN = new boolean[n]; // 0~n-1
        a = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                a[i][j] = sc.nextInt();


        for (int i = 0; i < q; i++) {
            int r = sc.nextInt();
            char d = sc.next().charAt(0);
            r -= 1;

            pushAndSpread(r, d);
        }

         for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
         }
            
    }

    public static void pushAndSpread(int r, char d) {
        visitedN[r] = true;

        if (d == 'L') {
            int lastVal = a[r][m-1];
            for (int i = m-1; i >= 1; i--) {
                a[r][i] = a[r][i-1];
            }
            a[r][0] = lastVal;
        } else {
            int firstVal = a[r][0];
            for (int i = 0; i < m-1; i++) {
                a[r][i] = a[r][i+1];
            }
            a[r][m-1] = firstVal;
        }

        boolean topEqual = false;
        boolean bottomEqual = false;
        for (int i = 0; i < m; i++) {

            if (r-1 >= 0 && r-1 < n && !visitedN[r-1]) {
                if (a[r][i] == a[r-1][i]) {
                    topEqual = true;
                }
            }

            if (r+1 >= 0 && r+1 < n && !visitedN[r+1]) {
                if (a[r][i] == a[r+1][i]) {
                    bottomEqual = true;
                }
            }
        }

        if (topEqual) {
            if (d == 'L') {
                pushAndSpread(r-1, 'R');
            } else {
                pushAndSpread(r-1, 'L');
            }
        }

        if (bottomEqual) {
            if (d == 'L') {
                pushAndSpread(r+1, 'R');
            } else {
                pushAndSpread(r+1, 'L');
            }
        }
        

        visitedN[r] = false;
    }
}

// 문제

// 이해
// 바람의 진행 방향대로 해당 행을 민다.
// 미는 함수가 필요함
// 행 방문 boolean[]가 필요함.
// 밀 때마다 위아래 행의 일치 여부를 체크하고 일치하면 각각을 true로 만든다.
// 밀고나서 양방향으로 행이 존재하고, 방문하지 않았고 일치하는 값이 존재했다면(true) 
// 해당 행을 다시 탐색하는 함수를 돌린다.

// 