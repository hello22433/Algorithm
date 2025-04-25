
import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static int max = Integer.MIN_VALUE;
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        dfs(0, map);
        System.out.println(max);
    }

    private static void dfs(int depth, int[][] board) {
        if (depth == 5) {
            max = Math.max(max, getMaxBlock(board));
            return;
        }

        for (int dir = 0; dir < 4; dir++) {
            int[][] newBoard = move(board, dir);
            dfs(depth + 1, newBoard);
        }
    }

    private static int[][] move(int[][] board, int dir) {
        int[][] newBoard = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                newBoard[i][j] = board[i][j];
            }
        }

        for (int i = 0; i < board.length; i++) {
            int[] line = new int[N];
            int lineIdx = 0;
            boolean[] merged = new boolean[N];

            for (int j = 0; j < board[i].length; j++) {
                int r = i, c = j;
                if (dir == 1) { r = i; c = N - 1 - j; }
                if (dir == 2) { r = j; c = i; }
                if (dir == 3) { r = N - 1 - j; c = i; }

                int val = newBoard[r][c];

                if (val == 0) continue;
                if (line[lineIdx] == 0) {
                    line[lineIdx] = val;
                } else if (!merged[lineIdx] && line[lineIdx] == val) {
                    merged[lineIdx] = true;
                    line[lineIdx] *= 2;
                } else {
                    lineIdx++;
                    line[lineIdx] = val;
                }
            }

            for (int j = 0; j < board[i].length; j++) {
                int r = i, c = j;
                if (dir == 1) { r = i; c = N - 1 - j; }
                if (dir == 2) { r = j; c = i; }
                if (dir == 3) { r = N - 1 - j; c = i; }

                newBoard[r][c] = line[j];
            }
        }
        return newBoard;
    }

    private static int getMaxBlock(int[][] board) {
        int val = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                val = Math.max(val, board[i][j]);
            }
        }

        return val;
    }
}





//