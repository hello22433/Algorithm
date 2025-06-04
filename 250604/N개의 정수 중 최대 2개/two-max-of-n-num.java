import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
         int n = sc.nextInt();
         int max1 = sc.nextInt();
         int max2 = Integer.MIN_VALUE;

        for (int i = 0; i < n-1; i++) {
            int num = sc.nextInt();
            if (max1 >= num) {
                max2 = Math.max(max2, num);
            } else {
                max2 = max1;
            }
            
            max1 = Math.max(max1, num);
            
            

        }
        System.out.print(max1 + " " + max2);
    }
}
