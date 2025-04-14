
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        String seats = sc.nextLine();
        StringBuilder sb = new StringBuilder("*");

        for (int i = 0; i < seats.length(); i++) {
            // 만약 S가 나오면 뒤에 더한다. i에 1을 더한다.
            // 만약 L이 나오면 L과 *을 더하고 i에 2를 더한다.
            if (seats.charAt(i) == 'S') {
                sb.append("S");
                sb.append("*");
            } else if (seats.charAt(i) == 'L') {
                sb.append("L");
                sb.append("L");
                sb.append("*");
                i++;
            }
        }

        int count = 0;
        boolean[] visited = new boolean[sb.length()];
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '*') continue;

            if (sb.charAt(i) == 'S') {
                int left = Math.max(0, i - 1);
                int right = Math.min(sb.length() - 1, i + 1);

                for (int j = left; j <= right; j++) {
                    if (!visited[j] && sb.charAt(j) == '*') {
                        visited[j] = true;
                        count++;
                        break;
                    }
                }
            } else if (sb.charAt(i) == 'L') {
                int left = Math.max(0, i - 1);
                int right = Math.min(sb.length() - 1, i + 1);

                for (int j = left; j <= right; j++) {
                    if (!visited[j] && sb.charAt(j) == '*') {
                        visited[j] = true;
                        count++;
                        break;
                    }
                }
            }
        }


        System.out.print(count);
        
        // *에 seats를 더한다.
        // 

    }
}


//