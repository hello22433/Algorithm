import java.util.Scanner;

public class Main {
    public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        
        if (a%2 != 0) {
            System.out.println("odd");
        } else {

            System.out.println("even");
        }
        

        if (b%2 != 0) {
            System.out.println("odd");
        } else {

            System.out.println("even");
        }


    }
}