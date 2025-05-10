import java.util.Scanner;

public class Main {
    static char direction;
    static int x, y;
    static char[][] grid;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < n; j++) {
                grid[i][j] = s.charAt(j);
            }
        }
        int K = sc.nextInt()-1;
        // Please write your code here.
        direction = 'X';
        // K에 대해서 진행방향 구하기 
        if (K/3 == 0) {
            direction = 'D';
            x = 0;
            y = K%3;
        } else if (K/3 == 1) {
            direction = 'L';
            x = K%3;
            y = n-1;
        } else if (K/3 == 2) {
            direction = 'U';
            x = n-1;
            y = n-1-K%3;
        } else if (K/3 == 3) {
            direction = 'R';
            x = n-1-K%3;
            y = 0;
        } 
        // 진행방향에 따른 상호작용(인덱스지정) -> 
        int count = 0;
        while (true) {
            count++;
            if (!moveAndCheck()) {
                break;
            }
        }
        System.out.print(count);
    }

    public static boolean moveAndCheck() {
        // 부딪힐 인덱스
        // 부딪히기 전의 진행방향
        if (direction == 'D') {
            if (grid[x][y]=='/') {
                direction = 'L';
                x = x;
                y -= 1;
            } else if (grid[x][y]=='\\') {
                direction = 'R';
                x = x;
                y += 1;
            }
        } else if (direction == 'L') {
            if (grid[x][y]=='/') {
                direction = 'D';
                x = x+1;
                y = y;
            } else if (grid[x][y]=='\\') {
                direction = 'U';
                x = x-1;
                y = y;
            }
        } else if (direction == 'U') {
            if (grid[x][y]=='/') {
                direction = 'R';
                x = x;
                y = y+1;
            } else if (grid[x][y]=='\\') {
                direction = 'L';
                x = x;
                y = y-1;
            }
        } else if (direction == 'R') {
            if (grid[x][y]=='/') {
                direction = 'U';
                x = x-1;
                y = y;
            } else if (grid[x][y]=='\\') {
                direction = 'D';
                x = x+1;
                y = y;
            }
        }

        if (x>=0 && x<n && y>=0 && y<n) {
            return true;
        } else {
            return false;
        }
    }
}

// /인데 오른쪽에서 오면 아래로, 아래에서 오면 오른쪽으로 간다.
// 왼쪽에서 오면 위로, 위에서 오면 왼쪽으로 간다.
// \인데 오른쪽에서 오면 위로, 위에서 오면 오른쪽으로 간다.
// 왼쪽에서 오면 아래로, 아래에서 오면 왼쪽으로 간다.
// 012 345 678 91011
// K를 3으로 나눴을떄 몫이 0이면 위, 1이면, 오른쪽, 2이면 아래, 3이면 왼쪽 으로 진행방향이 바뀐다.
// 몫이 0이면 0행일때 나머지가 열의 인덱스를 말한다.
// 몫이 1이면 n-1열(마지막열)일 때 나머지가 행의 인덱스를 말한다.
// 몫이 2이면 n-1행(마지막행)일 때 (n-1)-j(나머지)가 열의 인덱스를 말한다.
// 몫이 3이면 0열일때 나머지가 (n-1)-j가 행의 인덱스를 말한다.
// 
// 진행방향 지정 -> 해당 인덱스와 상호작용(K) : 진행방향 지정
// -> 진행방향에 따라 인덱스 지정 -> 위:행-1, 오:열+1, 아:행+1, 왼:열-1
// -> 해당 인덱스와 상호작용 : 진행방향 지정 -> 진행방향에 따라 인덱스 지정
// 상호작용 할 때마다 카운트
// 만약 인덱스가 인덱스 밖으로 나가면 종료