import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        int count = 0;
        for (int i = 0; i < input.length()-3; i++) {
            if (input.charAt(i) == ')' || input.charAt(i+1) == ')') continue;
            for (int j = i+2; j < input.length()-1; j++) {
                if (input.charAt(j) == '(' || input.charAt(j+1) == '(') continue;
                count++;
        }
    }
    System.out.print(count);
}
}

// 