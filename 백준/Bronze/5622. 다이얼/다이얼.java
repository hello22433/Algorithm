import java.util.*;


class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            int a = s.charAt(i) - 'A';

            if (s.charAt(i) >= 'S') {
                a -= 1;
            }
            if (s.charAt(i) == 'Z') {
                a -= 1;
            }
            sum += a/3+1+2;
        }
        System.out.println(sum);
    }

}

// 매핑하는식
// 3으로 나눈 몫으로 가는 식 (문자가 한 숫자에 4개인 경우는?)
//