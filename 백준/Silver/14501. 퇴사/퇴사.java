
import java.util.*;

public class Main {
    static int N;
    static int[][] Narr;
    static int result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        Narr = new int[N+1][2];

        for (int i = 1; i <= N; i++) {
            Narr[i][0] = sc.nextInt(); // Ti
            Narr[i][1] = sc.nextInt(); // Pi
        }
        
        dfs(1,0);

        System.out.println(result);
    }

    private static void dfs(int day, int sum) {
        if (day == N+1) {
            result = Math.max(result, sum);
            return;
        }
        
        if (day + Narr[day][0] <= N+1) {
            dfs(day+Narr[day][0], sum+Narr[day][1]);
        }
       
        dfs(day+1, sum);
    }
}



// 하루에 하나씩 서로 다른 사람의 상담을 잡아놓았다.
// Ti-1만큼 앞으로는 상담을 할 수 없다.
// i=0 i<N 까지 인덱스에 각각을 배열로 저장한다.
// Ti만큼 i에 더한다.
// sum+= Pi.
// 만약 i가 N-1을 넘어가면(인덱스 최대) return하고 result=Math.max(sum,result)