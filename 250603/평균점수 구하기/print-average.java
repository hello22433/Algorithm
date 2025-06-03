import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        double[] arr = new double[8];  // 크기가 n인 실수형을 저장하기 위한 배열 선언
        double sum = 0;

        for (int i = 0; i < 8; i++) {
            arr[i] = sc.nextDouble();
            sum += arr[i];
        }
        
        System.out.printf("%.1f", sum/8);
    }
}
