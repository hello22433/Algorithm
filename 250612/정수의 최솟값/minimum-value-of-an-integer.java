import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        // Please write your code here.

        printMinValue(a,b,c);
    }

    public static void printMinValue(int a, int b, int c){
        System.out.print(Math.min(a,Math.min(b,c)));
    }
}