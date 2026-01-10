import java.util.*;

class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        int[] trees = new int[n];
        for (int i = 0; i < n; i++) {
            trees[i] = sc.nextInt();
        }
        
        trees = Arrays.stream(trees)
            .boxed()
            .sorted((a,b) -> b-a)
            .mapToInt(Integer::intValue)
            .toArray();
        
        int maxTreeGrowingDate = 0;
        
        
        for (int i = 0; i < n; i++) {
            int date = i+1;
            maxTreeGrowingDate = Math.max(maxTreeGrowingDate, trees[i] + date);
        }
        
        System.out.print(maxTreeGrowingDate + 1);
    }
}