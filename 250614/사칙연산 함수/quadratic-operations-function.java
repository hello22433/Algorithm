import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        char o = sc.next().charAt(0);
        int c = sc.nextInt();
        // Please write your code here.

        String result = "";
        if (o == '+') {
            result = String.format("%d %c %d = %s", a, o, c, calPlus(a,c));
        } else if (o == '-') {
            result = String.format("%d %c %d = %s", a, o, c, calMinus(a,c));
        } else if (o == '/') {
            result = String.format("%d %c %d = %s", a, o, c, calDivide(a,c));
        } else if (o == '*') {
            result = String.format("%d %c %d = %s", a, o, c, calMultiple(a,c));
        } else {
            result = "False";
        }

        System.out.print(result);
    }

    public static String calPlus(int a, int c) {
        return String.valueOf(a + c);
    } 

    public static String calMinus(int a, int c) {
        return String.valueOf(a - c);
    } 

    public static String calDivide(int a, int c) {
        return String.valueOf(a / c);
    } 

    public static String calMultiple(int a, int c) {
        return String.valueOf(a * c);
    } 
}