// 적게 주는 애를 최대한 뒤로 미뤄서 음수로 만들어서 손해를 최소화해야 한다.
// 음수가 생길수록 이득 

import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            
            pq.add(num);
        }
        
        long result = 0;
        for (int i = 1; i <= n; i++) {
            int num = pq.poll();
            int sumNum = num - (i - 1);
            
            result += sumNum<0 ? 0 : sumNum;
        }
        System.out.print(result);
    }
}