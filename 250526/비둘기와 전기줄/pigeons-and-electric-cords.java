import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        boolean[] firstWatch = new boolean[11];
        int[] location = new int[11];
        int moveCnt = 0;
        for (int i = 0; i < N; i++) {
            int pigeon = sc.nextInt();
            int moveDir = sc.nextInt();

            if (!firstWatch[pigeon]) {
                firstWatch[pigeon] = true;
                location[pigeon] = moveDir;
            } else {
                if (location[pigeon] != moveDir) {
                    location[pigeon] = moveDir;
                    moveCnt++;
                } else {
                    
                }
            }
        }
        System.out.print(moveCnt);

        
    }
}

// 