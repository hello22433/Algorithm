import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        double[] arr = new double[n];  // 크기가 n인 실수형을 저장하기 위한 배열 선언
        double sum = 0;
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            // arr[i] = sc.nextDouble();
            int sum = 0;
            for (int j = 0; j < 4; j++) {
                sum += sc.nextInt();
            }

            if (sum / 4 >= 60) {
                System.out.println("pass");
                cnt++;
            } else {
                System.out.println("fail");
            }
            
        }

        System.out.print(cnt);
    }
}
