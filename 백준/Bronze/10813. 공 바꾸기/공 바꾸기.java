import java.io.*;
import java.util.*;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] baskets = new int[n+1];
        for (int i = 1; i <= n; i++) {
            baskets[i] = i;
        }
        
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            int temp = baskets[a];
            baskets[a] = baskets[b];
            baskets[b] = temp;
        }
        
        for (int i = 1; i <= n; i++) {
            System.out.print(baskets[i] + " ");
        }
        
        


    }


}
