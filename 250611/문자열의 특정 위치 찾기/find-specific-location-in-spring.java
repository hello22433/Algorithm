import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        String ch = sc.next();
        
        for (int i = 0; i < str.length(); i++) {
            if (String.valueOf(str.charAt(i)).equals(ch)){
                System.out.print(i);
                return;
            }
        }
        System.out.print("No");
    }
}