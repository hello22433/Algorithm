import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        // Please write your code here.

        String reverseInput = palindrome(input);

        if (input.equals(reverseInput)) {
            System.out.print("Yes");
        } else {
            System.out.print("No");
        }
    }

    public static String palindrome(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = s.length()-1; i >= 0; i--) {
            sb.append(String.valueOf(s.charAt(i)));
        }

        return sb.toString();
    }
}