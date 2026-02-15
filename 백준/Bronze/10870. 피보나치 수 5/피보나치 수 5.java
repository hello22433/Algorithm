import java.util.*;


class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        long a = 0;
        long b = 1;

        if (n == 0) {
            System.out.println("0");
            return;
        }

        for (int i = 2; i <= n; i++) {
            long temp = a+b;
            a = b;
            b = temp;
        }

        System.out.println(b);
    }

}

// 매핑하는식
// 3으로 나눈 몫으로 가는 식 (문자가 한 숫자에 4개인 경우는?)
//