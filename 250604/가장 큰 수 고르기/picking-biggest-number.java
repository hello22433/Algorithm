import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        int min = Integer.MIN_VALUE;
        for (int i = 1; i <= 10; i++) {
            int num = sc.nextInt();
            min = Math.max(min, num);
        }
        System.out.print(min);
    }
}
