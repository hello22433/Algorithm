import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String t = sc.next();
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = sc.next();
        }
        // Please write your code here.

        int idx = 0;
        String[] selectedWords = new String[n];

        for (int i = 0; i < n; i++) {
            if (t.equals(words[i].substring(0,t.length()))) {
                selectedWords[idx++] = words[i];
            }
        }

        String[] fixedSelectedWords = new String[idx];
        for (int i = 0; i < idx; i++) 
            fixedSelectedWords[i] = selectedWords[i];

        Arrays.sort(fixedSelectedWords);

        System.out.print(fixedSelectedWords[k-1]);
    }
}