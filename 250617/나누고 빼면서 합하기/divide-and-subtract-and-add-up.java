import java.util.Scanner;
public class Main {
    static int M;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        
        calAndPrint();

    }

    public static void calAndPrint() {
        int sum = arr[M-1];

        while (M != 1) {
            if (M % 2 == 1) {
                M -= 1;
            } else {
                M /= 2;
            }
            sum += arr[M-1];
        }

        System.out.print(sum);
    }
}


// arr를 글로벌 변수화
// M도 글로벌 변수화
// M이 1이 될때까지 계속 계산하며 arr 출력
//