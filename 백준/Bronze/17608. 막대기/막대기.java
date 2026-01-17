import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            st.push(num);
        }
        
        int curNum = st.pop();
        int cnt = 1;
        for (int i = 1; i < n; i++) {
            int num = st.pop();
            if (curNum < num) {
                cnt++;
                curNum = num;
            }
        }
        System.out.print(cnt);
    }
}