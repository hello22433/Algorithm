import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Set<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String s = sc.next();

            String reversedS = new StringBuilder(s).reverse().toString();
            
            if (set.contains(reversedS) || s.equals(reversedS)) {
                int len = reversedS.length();
                char mid = reversedS.charAt(len/2);
                System.out.print(len + " " + mid);
                return;
            } 
            
            set.add(s);
        }

    }
}