import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int aM = sc.nextInt();
        int aE = sc.nextInt();
        int bM = sc.nextInt();
        int bE = sc.nextInt();

        if (aM != bM) {
            if (aM > bM) System.out.print("A");
            if (aM < bM) System.out.print("B");
        } else {
            if (aE > bE) System.out.print("A");
            if (aE < bE) System.out.print("B");
            
        }
        
    }
}
