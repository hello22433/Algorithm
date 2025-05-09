import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = 0;
        int y = 0;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};
        int time = 0;
        for(int i = 1; i <= n; i++){
            char dir = sc.next().charAt(0);
            int directionIdx = moveToIdx(dir);
            int dist = sc.nextInt();
            
            for (int j = 0; j < dist; j++) {
                time++;
                x += dx[directionIdx];
                y += dy[directionIdx];
                if (x==0 && y==0) {
                    System.out.print(time);
                    return;
                }
            }

        }
        System.out.print(-1);
    }

    public static int moveToIdx(char d) {
        if (d=='E') {
            return 0;
        } else if (d=='S') {
            return 1;
        } else if (d=='W') {
            return 2;
        } else {
            return 3;
        } 
    }
}

// 매 움직임마다 현재 위치를 체크하고 0,0이면 그 때동안 움직인 횟수를 리턴
// 