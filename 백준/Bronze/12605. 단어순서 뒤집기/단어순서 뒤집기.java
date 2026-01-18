import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        sc.nextLine();
        
        for (int i = 1; i <= n; i++) {
            String[] st = sc.nextLine().split(" ");
            
            System.out.printf("Case #%d: ", i);
            for (int j = st.length-1; j >= 0; j--) {
                System.out.printf("%s ", st[j]);
            }
            System.out.println();
        }
        
        
    }
}