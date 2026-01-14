import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        int maxShootCnt = 0;
        int shootCnt = 0;
        int curShooter = sc.nextInt();
        
        for (int i = 1; i < n; i++) {
            int shooter = sc.nextInt();
            
            if (curShooter >= shooter) {
                shootCnt += 1;
            } else {
                maxShootCnt = Math.max(shootCnt, maxShootCnt);
                shootCnt = 0;
                curShooter = shooter;
            }
        }
        
        maxShootCnt = Math.max(shootCnt, maxShootCnt);
        
        
        System.out.print(maxShootCnt);
    }
}