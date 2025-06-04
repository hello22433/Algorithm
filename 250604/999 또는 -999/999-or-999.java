import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
         int max = Integer.MIN_VALUE;
         int min = Integer.MAX_VALUE;
        while (true) {
            int num = sc.nextInt();

            if (num == 999 || num == -999) {
                System.out.print(max + " " + min);
                break;
            }

            max = Math.max(num, max);
            min = Math.min(num, min);
        }
    }
}
