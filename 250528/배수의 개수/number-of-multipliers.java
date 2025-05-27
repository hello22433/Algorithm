import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.

        Scanner sc = new Scanner(System.in);

        int threetotal = 0;
        int fivetotal = 0;
        for (int i = 0; i < 10; i++) {
            int s = sc.nextInt();
            if (s%3==0) {
                threetotal += 1;
            } 
            if (s%5==0) {
                fivetotal+=1;
            } 
        }
        System.out.print(threetotal + " " + fivetotal);
    }
}