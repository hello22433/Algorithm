import java.util.*;


class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            // 공백
            for (int j = 1; j <= n-i; j++) {
                System.out.print(" ");
            }
            // *
            for (int j = 1; j <= 2*i-1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int i = n-1; i >= 1; i--) {
            // 공백
            for (int j = n-i; j >= 1; j--) {
                System.out.print(" ");
            }
            // *
            for (int j = 2*i-1; j >= 1; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

}

// 매핑하는식
// 3으로 나눈 몫으로 가는 식 (문자가 한 숫자에 4개인 경우는?)
//