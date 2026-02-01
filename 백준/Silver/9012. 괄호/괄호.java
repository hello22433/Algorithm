import java.util.*;


class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        outer : for (int i = 0; i < n; i++) {
            char[] line = sc.nextLine().toCharArray();
            Stack<Character> stack = new Stack<>();

            for (int j = 0; j < line.length; j++) {
                if (line[j] == ')') {
                    if (stack.empty() || stack.peek() == ')') {
                        System.out.println("NO");
                        continue outer;
                    }
                    stack.pop();
                } else {
                    stack.push(line[j]);
                }
            }

            if (stack.empty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }








    }
}