import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] arr = new int[5][5];
        arr[0][0] = 1;
        arr[0][1] = 1;
        arr[0][2] = 1;
        arr[0][3] = 1;
        arr[0][4] = 1;
        arr[0][0] = 1;
        arr[1][0] = 1;
        arr[2][0] = 1;
        arr[3][0] = 1;
        arr[4][0] = 1;

        
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 5; j++) {
                arr[i][j] = arr[i-1][j] + arr[i][j-1];
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}

// 1행에선 0씩 더하고
// 2행에선 1씩 더하고...