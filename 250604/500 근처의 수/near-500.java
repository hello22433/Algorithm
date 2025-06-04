import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            int num = sc.nextInt();

            if (num < 500) {
                max = Math.max(max, num);
            } else if (num > 500) {
                min = Math.min(min, num);
            }
        }
        System.out.print(max + " " + min);
    }
}
