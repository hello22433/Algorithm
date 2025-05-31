import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int sumVal = 0;
        while (true) {
            int age = sc.nextInt();
            
            if (age > 29 || age < 20) break;
            

            System.out.println(age);
            
        }
    }
}
