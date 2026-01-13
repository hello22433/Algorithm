import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        int curMilk = -1;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int milk = sc.nextInt();
            
            if (curMilk == 0) {
                if (milk == 1) {
                    curMilk = 1;
                    cnt += 1;
                }
            } else if (curMilk == 1) {
                if (milk == 2) {
                    curMilk = 2;
                    cnt += 1;
                }
            } else if (curMilk == 2) {
                if (milk == 0) {
                    curMilk = 0;
                    cnt += 1;
                }
            } else if (curMilk == -1) {
                if (milk == 0) {
                    curMilk = 0;
                    cnt += 1;
                }
            }
        }
        
        System.out.print(cnt);
    }
}