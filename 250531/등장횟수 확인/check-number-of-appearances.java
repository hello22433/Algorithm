import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int c = 0;
        for (int i = 1; i <= 5; i++) {
            
            if (sc.nextInt() % 2 ==0) {
                c +=1;
            } 
            
        }

        System.out.print(c);

    }
}

// 