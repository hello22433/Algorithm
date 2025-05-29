import java.util.Scanner;

public class Main {
    public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        
        if (a.equals("S")) {
            System.out.print("Superior");
        } else if (a.equals("A")) {
            System.out.print("Excellent");
        } else if (a.equals("B")) {
            System.out.print("Good");
        } else if (a.equals("C")) {
            System.out.print("Usually");
        } else if (a.equals("D")) {
            System.out.print("Effort");
        } else{
            System.out.print("Failure");
        }

 


    }
}