import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        double[] arr = new double[10];  // 크기가 n인 실수형을 저장하기 위한 배열 선언
        double sum = 0;
        int cnt = 0;

        for (int i = 0; i < 10; i++) {
            arr[i] = sc.nextDouble();
            if (arr[i] == 0) break;

            if (arr[i] % 2 ==0) {
                sum += arr[i];
                cnt++;
            }
            
        }
        System.out.printf("%d %.0f", cnt, sum);
        
        // for (int i = 9; i >= 0; i--) {
        //     if (arr[i] != 0)
    }
}
