import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word1 = sc.next();
        String word2 = sc.next();
        // Please write your code here.
        char[] word1Arr = word1.toCharArray();
        char[] word2Arr = word2.toCharArray();

        Arrays.sort(word1Arr);
        Arrays.sort(word2Arr);

        word1 = new String(word1Arr);
        word2 = new String(word2Arr);

        if (word1.equals(word2)) System.out.print("Yes");
        else System.out.print("No");
    }
}