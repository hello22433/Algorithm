import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int sumVal = 0;
        int cnt = 0;
        for (int i = a; i <= b; i++) {
            
            if (i % 5 == 0 || i% 7 == 0) {
cnt++;
            sumVal += i;
            }
            
            
        }

        System.out.printf("%d %.1f", sumVal, sumVal/(double)cnt);

    }
}

// 