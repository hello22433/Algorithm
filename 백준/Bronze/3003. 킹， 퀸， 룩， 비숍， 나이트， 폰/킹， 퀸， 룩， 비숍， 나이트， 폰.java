import java.util.*;


class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        String s = sc.nextLine();
//        int a = sc.nextInt();
//        int b = sc.nextInt();
//        int sum = 0;

        int[] arr = {1,1,2,2,2,8};

        for (int i = 0; i < 6; i++) {
            int a = sc.nextInt();
            System.out.print(arr[i] - a + " ");
        }

    }

}

// 매핑하는식
// 3으로 나눈 몫으로 가는 식 (문자가 한 숫자에 4개인 경우는?)
//