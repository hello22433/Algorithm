import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int a = sc.nextInt();

        int sumVal = 1;
        int cnt = 0;
        for (int i = a; i <= a; i++) {

            if (i % 2 == 0 ) continue;
            if (i % 10 == 5) continue;
            if (i % 3 == 0 && i % 9 != 0) continue;

            System.out.print(i + " ");
            
        }
        
        

    }
}

// 