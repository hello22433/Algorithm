import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        // Please write your code here.

        char[] chArr = s.toCharArray();
        Arrays.sort(chArr);
        String newS = new String(chArr);
        System.out.print(newS);
    }
}