import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int a = sc.nextInt();

        int sumVal = 1;
        int cnt = 0;
        for (int i = 1; i <= 10; i++) {

            if (sumVal * i >= a) {
                System.out.print(i);
                break; 
            }

            sumVal *= i;
            
        }
        
        

    }
}

// 