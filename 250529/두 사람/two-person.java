import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int aA = sc.nextInt();
        String aS = sc.next();
        int bA = sc.nextInt();
        String bS = sc.next();

        if (aA >= 19 && aS.equals("M") || bA >= 19 && bS.equals("M")) {
            System.out.print("1");
        } else {
            System.out.print("0");
            
        }
        
    }
}
