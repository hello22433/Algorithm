import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int a = sc.nextInt();

        int sumVal = 0;
        int cnt = 0;
        for (int i = 1; i <= 100; i++) {

            if (sumVal + i >= a) {
                System.out.print(i-1);
                break; 
            }

            sumVal += i;
            
        }
        
        

    }
}

// 