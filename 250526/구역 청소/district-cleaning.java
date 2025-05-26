import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        // Please write your code here.
        
        if (b < c || d < a) {
            System.out.print(b-a+d-c);
        } else {
            int start = Math.min(a,c);
            int end = Math.max(b,d);
            System.out.print(end-start);
        }
    }
}

// 