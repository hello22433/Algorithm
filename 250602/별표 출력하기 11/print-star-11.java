import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int cnt = 0;
        for (int i = 1; i <= n*2 +1; i++) {
            if (i%2 != 0) {
                for (int j = 1; j <= n*2 +1; j++) {
                    System.out.print("* ");
                }
            } else {
                for (int j = 1; j <= (n*2 +1)/2+1; j++) {
                    System.out.print("* ");
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

    }
}


// n * 2 + 1 만큼의 행이 존재
// 열도 마찬가지
// 행이 홀수일때 (1에서 시작 기준) 모든 열에 *을 찍는다.
// 행이 짝수일때 홀수인 열에만 *을 찍고 짝수인 열에는 공백을 찍는다.