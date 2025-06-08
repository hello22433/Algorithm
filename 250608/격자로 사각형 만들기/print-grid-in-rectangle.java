import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] box = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0 || i == 0) {
                    box[i][j] = 1;
                } else {
                    box[i][j] = box[i - 1][j - 1] + box[i - 1][j] + box[i][j-1];
                }
            }
        } 

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n ; j++) {
                System.out.print(box[i][j] + " ");
            }
            System.out.println();
        } 
    }
}

// 1행에선 1개
// 2행에선 2개
// 3행에선 3개..
// 일단 n X n 을 만들고
// 채운다. 
