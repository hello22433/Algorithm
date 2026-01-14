import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        
        int preH = Integer.parseInt(st.nextToken());
        int cnt = 1;
        
        for (int i = 1; i < n; i++) {
            int h = Integer.parseInt(st.nextToken());

            if (preH > h) {
            } else {
                cnt += 1;
            }

            preH = h;
        }
        System.out.print(cnt);


    }
}