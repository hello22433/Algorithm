import java.util.*;


class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] fibonacci = new int[n+1];
        fibonacci[0] = 0;
        if (n == 0) {
            System.out.println(0);
            return;
        }
        fibonacci[1] = 1;

        for (int i = 2; i <= n; i++) {
            fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];
        }
        System.out.println(fibonacci[n]);

    }

}

// 매핑하는식
// 3으로 나눈 몫으로 가는 식 (문자가 한 숫자에 4개인 경우는?)
//