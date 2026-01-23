import java.util.*;


class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        char[] line = sc.nextLine().toCharArray();

        int[][] board = new int[2*n+2][2*n+2];

        // 동 남 서 북
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};

        Map<Character, Integer> map = new HashMap<>();


        map.put('E', 0);
        map.put('S', 1);
        map.put('W', 2);
        map.put('N', 3);

        int curX = n;
        int curY = n;
        int cnt = 0;
        board[curX][curY] += 1;
        if (board[curX][curY] == 1) {
            cnt++;
        }

        for (char l : line) {
            int dir = map.get(l);
            curX = curX + dx[dir];
            curY = curY + dy[dir];

            board[curX][curY] += 1;
            if (board[curX][curY] == 1) {
                cnt++;
            }

        }

        System.out.println(cnt);


    }
}