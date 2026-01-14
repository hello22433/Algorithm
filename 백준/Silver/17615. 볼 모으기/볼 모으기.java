import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] line = sc.next().toCharArray();


        char moveCol = 'R';
        char wallCol = 'B';
        int moveCnt = 0;
        boolean checkWall = false;
        for (int i = n-1; i >= 0; i--) {
            if (line[i] == wallCol) {checkWall = true;}
            if (checkWall && line[i] == moveCol) {
                moveCnt++;
            }
        }

        int minMoveCnt = moveCnt;

        moveCol = 'B';
        wallCol = 'R';
        moveCnt = 0;
        checkWall = false;
        for (int i = n-1; i >= 0; i--) {
            if (line[i] == wallCol) {checkWall = true;}
            if (checkWall && line[i] == moveCol) {
                moveCnt++;
            }
        }

        minMoveCnt = Math.min(minMoveCnt, moveCnt);

        System.out.println(minMoveCnt);
    }
}