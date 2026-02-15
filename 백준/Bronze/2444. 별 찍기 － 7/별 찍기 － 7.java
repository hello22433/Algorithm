import java.util.*;


class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 1; i <= 2*n-1; i++) {

            int distance = Math.abs(n-i);
            int star = 2*(n-distance) -1;
            int space = distance;

            for (int j = 0; j < distance; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j < star; j++) {
                System.out.print("*");
            }

            System.out.println();

        }

    }

}

// 매핑하는식
// 3으로 나눈 몫으로 가는 식 (문자가 한 숫자에 4개인 경우는?)
//