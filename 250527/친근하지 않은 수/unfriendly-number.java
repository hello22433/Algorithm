import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc= new Scanner(System.in);

        int a = sc.nextInt();

        for (int i = 1; i <=a; i++) {
            
            if (i%2!=0 || i%3!=0 || i%5!=0) continue;
            System.out.print(i);
        }
    }
}