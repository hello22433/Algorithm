import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int sum = 0;
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            sum += num;
        }

        String sumStr = Integer.toString(sum);
        sumStr = sumStr.substring(1) + sumStr.substring(0,1);
        System.out.print(sumStr);
    }
}

