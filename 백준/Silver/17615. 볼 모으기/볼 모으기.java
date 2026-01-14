import java.util.*;
import java.io.*;

class Main {
    private static int countMoveRight(char[] line, char moveCol, char wallCol) {
        int moveCnt = 0;
        boolean checkWall = false;
        for (int i = line.length-1; i >= 0; i--) {
            if (line[i] == wallCol) {checkWall = true;}
            if (checkWall && line[i] == moveCol) {
                moveCnt++;
            }
        }
        return moveCnt;
    }

    private static int countMoveLeft(char[] line, char moveCol, char wallCol) {
        int moveCnt = 0;
        boolean checkWall = false;
        for (int i = 0; i < line.length; i++) {
            if (line[i] == wallCol) {checkWall = true;}
            if (checkWall && line[i] == moveCol) {
                moveCnt++;
            }
        }
        return moveCnt;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] line = br.readLine().toCharArray();
        
        

        int minMoveCnt = Math.min(
                countMoveRight(line, 'R','B'),
                countMoveRight(line, 'B','R')
        );
        minMoveCnt = Math.min(minMoveCnt, countMoveLeft(line, 'R','B'));
        minMoveCnt = Math.min(minMoveCnt, countMoveLeft(line, 'B','R'));

        System.out.println(minMoveCnt);
    }
}