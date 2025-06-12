import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String A = sc.next();
        String B = sc.next();
        
        System.out.print((int)A.charAt(0) + (int)B.charAt(0) 
                        + " " 
                        + Math.abs((int)A.charAt(0) - (int)B.charAt(0)));
    }
}