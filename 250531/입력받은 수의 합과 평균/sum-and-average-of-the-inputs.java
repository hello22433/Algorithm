import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();

        int sumVal = 0;
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            int num = sc.nextInt();
        
            sumVal += num;
            cnt++;
            
        }
        
        

        System.out.printf("%d %.1f", sumVal, sumVal/(double)cnt);

    }
}

// 