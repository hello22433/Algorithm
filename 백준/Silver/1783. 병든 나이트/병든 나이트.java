
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        int count = 0;
        // N이 1일 경우 그 자리만 카운트
        if (N == 1) {
            count = 1;
        } else if (N == 2) {
            count = Math.min(4,(M-1)/2 + 1);
        } else if (N >= 3) {
            if (M < 7) {
                count = Math.min(4, M);
            } else {
                count = M-2;
            }
        }
        
        System.out.print(count);
        // N이 2일 경우 2칸씩 오른쪽으로 갈 것임. 
        // 다만 4칸 이상 갈 수 없음.(이동횟수 <= 3) 이동횟수+1 (M-1)/2 + 1
        
        // N이 3이상일 경우 M이 7미만이면 4칸 이상 갈 수 없음. 1칸씩 갈것이므로 M
        // 7이상이면 M-2 (모든 이동방식을 해야 하므로 2칸은 씩 두 번 움직여야 함 -> M에서 -2뺌)
        
        
    }
}


// 