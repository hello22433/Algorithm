import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();

        int sumVal = 0;
        for (int i = 1; i <= a; i++) {
            int num = sc.nextInt();
            if (num % 2 == 1 && num % 3 == 0)
            sumVal += num;
            
        }

        System.out.print(sumVal);

    }
}

// 