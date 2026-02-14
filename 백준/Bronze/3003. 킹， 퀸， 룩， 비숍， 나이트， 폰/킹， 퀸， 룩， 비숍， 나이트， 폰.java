import java.util.*;


class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        String s = sc.nextLine();
//        int a = sc.nextInt();
//        int b = sc.nextInt();
//        int sum = 0;

        int[] input = new int[6];
        int[] arr = {1,1,2,2,2,8};

        for (int i = 0; i < input.length; i++) {
            int a = sc.nextInt();
            input[i] = a;
        }
        
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] - input[i] + " ");
        }

    }

}

// 매핑하는식
// 3으로 나눈 몫으로 가는 식 (문자가 한 숫자에 4개인 경우는?)
//