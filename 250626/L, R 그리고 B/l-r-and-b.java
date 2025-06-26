import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] board = new char[10][10];
        int LX = -1;
        int LY = -1;
        int BX = -1;
        int BY = -1;
        int RX = -1;
        int RY = -1;
        for (int i = 0; i < 10; i++) {
            board[i] = sc.next().toCharArray();
            for (int j = 0; j < 10; j++) {
                if (board[i][j] == 'L') {
                    LX = i;
                    LY = j;
                }
                if (board[i][j] == 'B') {
                    BX = i;
                    BY = j;
                }
                if (board[i][j] == 'R') {
                    RX = i;
                    RY = j;
                }
            }
        }
        if ((RX == LX && RX == BX) || (RY == LY && RY == BY)) {
            System.out.print(Math.abs(LX-BX) + Math.abs(LY-BY) - 1 + 2);
        } else {
            System.out.print(Math.abs(LX-BX) + Math.abs(LY-BY) - 1);
        }

    }
}

// 문제
// B에서 L로 가는 길에는 여러 최단 루트가 있다. 
// 움직이는 길의 길이는 B와 L을 꼭짓점으로 하는 사각형에서 돌아가지만 않으면 일정하다.
// R은 그 중의 한 루트만 막으므로 루트의 길이만을 구하여 출력하면 된다.