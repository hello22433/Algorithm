import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        double[] arr = new double[n];  // 크기가 n인 실수형을 저장하기 위한 배열 선언
        double sum = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextDouble();
            sum += arr[i];
        }
        String str = "";
        if (sum/n >= 4.0) {
            str = "Perfect";
        } else if (sum/n >= 3.0) {
            str = "Good";
        } else {
            str = "Poor";
        }
        System.out.printf("%.1f\n%s", sum/n, str);
    }
}
