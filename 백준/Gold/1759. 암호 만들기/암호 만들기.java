
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static int L;
    static int C;
    static String[] arr;
    static boolean[] visited;
    static BufferedWriter bw;
    static Set<String> vowels = new HashSet<>(Arrays.asList("a", "e", "i", "o", "u"));

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        L = sc.nextInt();
        C = sc.nextInt();
        arr = new String[C];
        for (int i = 0; i < C; i++) {
            arr[i] = sc.next();
        }
        visited = new boolean[C];
        Arrays.sort(arr);


        dfs(0,"", 0, 0);
        bw.flush();
        bw.close();
    }

    private static void dfs(int idx, String Str, int vowelCnt, int consonantCnt) throws IOException {
        if (Str.length() == L) {
            if (vowelCnt >= 1 && consonantCnt >= 2) {
                bw.write(Str + "\n");
            }
            return;
        }

        for (int i = idx; i < C; i++) {
            if (vowels.contains(arr[i])) {
                dfs(i+1, Str+arr[i], vowelCnt + 1, consonantCnt);
            } else {
                dfs(i+1, Str+arr[i], vowelCnt, consonantCnt + 1);
            }
        }
    }
}




// 최소 한 개의 모음 aeiou
//