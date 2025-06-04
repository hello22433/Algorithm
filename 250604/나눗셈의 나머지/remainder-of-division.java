import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int a = sc.nextInt();
        int b = sc.nextInt();
        // 나머지는 0부터 1000
        int[] remains = new int[1001];

        while (a > 1) {
            int remain = a % b;
            remains[remain]++;
            a = a / b;
        }

        int val = 0;
        for (int i = 0; i < remains.length; i++) {
            val += remains[i] * remains[i];
        }
    }
}
