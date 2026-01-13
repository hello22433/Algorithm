import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String LS = sc.next();
        String RS = sc.next();
        
        int result = 0;
        if (LS.length() != RS.length()) {
            System.out.print(0);
            return;
        }
        
        for (int i = 0; i < LS.length(); i++) {
            if (LS.charAt(i) == RS.charAt(i)) {
                if (RS.charAt(i) == '8') {
                    
                    result += 1;
                }
            } else {
                break;
            }
        }
        
        System.out.print(result);
    }
}