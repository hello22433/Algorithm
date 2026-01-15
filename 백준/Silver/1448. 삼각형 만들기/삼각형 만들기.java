import java.util.*;
import java.io.*;


class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] sides = new int[n];
        for (int i = 0; i < n; i++) {
            int side = Integer.parseInt(br.readLine());
            sides[i] = side;
        }
        
        Arrays.sort(sides);
            
        for (int i = n-1; i >= 2; i--) {
            if (sides[i] < sides[i-1] + sides[i-2]) {
                System.out.print(sides[i] + sides[i-1] + sides[i-2]);
                return;
            }
        }
        System.out.print(-1);
    }
}