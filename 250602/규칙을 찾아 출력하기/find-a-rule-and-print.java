import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            if (i == 0 || i == n-1) {
                for (int j = 0; j < n; j++) {
                    System.out.print("* ");
                }
                System.out.println();
            } else {
                for (int j = 0; j <= i-1; j++) {
                    System.out.print("* ");
                }
                for (int j = 0; j < n-2-(i-1); j++) {
                    System.out.print("  ");
                }
                System.out.println("*");
            }
        }

    }
}


// 처음과 마지막 행에는 각 열에 "* "를 출력
// 둘째부터는 처음에 1로 시작해서 하나씩 더해가며 출력