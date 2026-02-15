import java.util.*;


class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int center = n-1;

        for (int col = 0; col < 2*n-1; col++) {
            boolean check = false;
            for (int row = 0; row < 2*n-1; row++) {
                if (Math.abs(row - center) + Math.abs(col - center) <= n-1) {
                    System.out.print("*");
                    check = true;
                } else {
                    if (check) break;
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

    }

}

// 매핑하는식
// 3으로 나눈 몫으로 가는 식 (문자가 한 숫자에 4개인 경우는?)
//