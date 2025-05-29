import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int[] daysOfMonth = {0,31,28,31,30,31,30,31,31,30,31,30,31};

        System.out.print(daysOfMonth[s]);
    }
}
