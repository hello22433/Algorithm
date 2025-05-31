import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();

        int sumVal = 0;
        int cnt = 0;
        for (int i = 1; i < n; i++) {
        
            if (n % i == 0) {

                sumVal += i;
            }
            
        }
        
        
        if (sumVal == n) System.out.print('P');
        else System.out.print('N');

    }
}

// 