import java.util.Scanner;
import java.util.Stack;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                s.push('(');
            } else {
                if (s.isEmpty()){
                    System.out.print("No");
                    return;
                }
                s.pop();
            }
        }
        
        if (s.isEmpty()) {
            System.out.print("Yes");
        } else {
            System.out.print("No");
        }
    }
}