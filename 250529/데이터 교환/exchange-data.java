public class Main {
    public static void main(String[] args) {
        // Please write your code here.

        int a = 5;
        int b = 6;
        int c = 7;
        int tempb = b;
        b = a;
        int tempc = c;
        c = tempb;
        a = tempc;
        System.out.print(a+"\n"+b+"\n"+c);
    }
}