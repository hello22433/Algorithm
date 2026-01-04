import java.util.*;

class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        int[] arr = new int[n];
        int[] diff = new int[n-1];
        
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            
            if (i > 0) {
                diff[i-1] = arr[i] - arr[i-1];
            }
        }
        
        // 가장 높은 차를 가진 연결지점에서 조를 나눠야한다
        // 그렇다면, n명의 사람에서 k개의 조를 만든다는건 k-1개의 경계가 생긴다는것
        // 즉, k-1개의 경계만 빼고 그 차합들을 모두 더하면, 가장 큰 사람과 작은 사람의 키의 합이 된다.
        // 왜냐하면, k-1개의 경계의 차들은 모두 사라지고, 나머지 차들은 그 조 내에서의 차이기 때문이다. 
        
        Arrays.sort(diff);
        
        int score = 0;
        
        for (int i = 0; i < n-1-(k-1); i++) {
            score += diff[i];
        }
        
        System.out.print(score);
        
        
    }
}