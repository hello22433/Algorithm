import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String commands = sc.next();

        int directionIdx = 3;
        int x = 0, y = 0;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};

        for (int i = 0; i < commands.length(); i++) {
            char command = commands.charAt(i);
            if (command == 'F') {
                x += dx[directionIdx];
                y += dy[directionIdx];
            } else if (command == 'L') {
                directionIdx = (directionIdx+1) % 4;
            } else if (command == 'R') {
                directionIdx = (directionIdx-1+4) % 4;
            }
            if (x==0 && y==0) {
                System.out.print(i+1);
                return;
            }
        }
        System.out.print(-1);
    }

    
}

// 