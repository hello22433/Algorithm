import java.util.*;

class Main {
    static char[] s1;
    static char[] s2;
    static char[] target;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        sc.nextLine();
        s1 = sc.nextLine().toCharArray();
        s2 = s1.clone();
        target = sc.nextLine().toCharArray();
        
        int minClicks = Integer.MAX_VALUE;
        
        // 1번 누름
        switchIdx(0, s1);
        int res1 = simulate(s1);
        if (res1 != Integer.MAX_VALUE) {
            minClicks = Math.min(minClicks, res1 + 1);
        }
        
        // 1번 안누름
        minClicks = Math.min(minClicks, simulate(s2));
        
        if (minClicks == Integer.MAX_VALUE) {
            System.out.print(-1);
        } else {
            System.out.print(minClicks);
        }
        
    }
    
    public static void switchIdx(int idx, char[] s) {
        for (int i = Math.max(0,idx-1); i <= Math.min(idx+1, s.length-1); i++) {
            if (s[i] == '0') {
                s[i] = '1';
            } else {
                s[i] = '0';
            }
        }
        
        
    }
    
    public static int simulate(char[] s) {
        
        int clicks = 0;
        
        for (int i = 1; i < s.length; i++) {
            if (s[i-1] != target[i-1]) {
                switchIdx(i, s);
                clicks += 1;
            }
        }
        
        if (Arrays.equals(s, target)) {
            return clicks;
        }
        return Integer.MAX_VALUE;
    }
}