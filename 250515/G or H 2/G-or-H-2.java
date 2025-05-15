import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // int[] positions = new int[n];
        // char[] chs = new char[n];
        char[] line = new char[101];
        for (int i = 0; i < n; i++) {
            int position = sc.nextInt();
            char ch = sc.next().charAt(0);

            // positions[i] = position;
            // chs[i] = ch;
            line[position] = ch;
        }

        // Please write your code here.
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 101; i++) {
            for (int j = i; j < 101; j++) {
                int HCount = 0;
                int GCount = 0;
                boolean no_firstORLast_char = false;
                for (int k = i; k <= j; k++) {
                    if ((k == i || k == j) && (line[k] != 'G' && line[k] != 'H')) {
                        no_firstORLast_char = true;
                        break;
                    }
                    if (line[k] == 'G') GCount++;
                    if (line[k] == 'H') HCount++;
                }
                if (no_firstORLast_char) continue;
                // if (GCount+HCount == 1) {max = Math.max(max, 0); continue;}
                if (GCount == 0 && HCount != 0) {
                    max = Math.max(max, j-i);
                } else if (GCount != 0 && HCount == 0) {
                    max = Math.max(max, j-i);
                } else if (GCount == HCount) {
                    max = Math.max(max, j-i);
                }
            }
        }
        System.out.print(max);
        
    }
}

// 