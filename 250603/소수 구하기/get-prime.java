import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        outer : for (int i = 2; i < n+1; i++) {
           
            for(int j = 2; j < i; j++) {
                if (i % j == 0) continue outer;
            }
            
            System.out.print(i + " ");
        }
    }
}
