import java.util.*;

class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String s = sc.nextLine();
        Character[] UCPC = new Character[]{'U','C','P','C'};
        int idx = 0;
        for (char c : s.toCharArray()) {
            if (idx > 3) break;
            
            if (c == UCPC[idx]) {
                idx += 1;
            }
        }
        
        if (idx > 3) {
            System.out.print("I love UCPC");
        } else {
            System.out.print("I hate UCPC");
        }
    }
}