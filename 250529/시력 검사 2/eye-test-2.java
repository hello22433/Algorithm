import java.util.Scanner;

public class Main {
    public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        

        if (a>=1) {
            System.out.print("High");
        } else if (a>= 0.5) {
            System.out.print("Middle");
        } else {
            System.out.print("Low");
        }


    }
}