import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int aA = sc.nextInt();
        String aS = sc.next();
        int bA = sc.nextInt();
        String bS = sc.next();

        if (aA >= 19 || bA >= 19) {
            if (aS.equals("M") || bS.equals("M")) System.out.print("1");
            else System.out.print("0");
        } else {
            System.out.print("0");
            
        }
        
    }
}
