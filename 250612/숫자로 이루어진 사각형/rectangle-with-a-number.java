import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        printStarsRowCol(N);
    }

    public static void printStarsRowCol(int N) {
        int num = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(num++ + " ");
                if (num == 10) num = 1;
            }
            System.out.println();
        }
    }
}