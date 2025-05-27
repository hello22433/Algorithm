import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.

        Scanner sc = new Scanner(System.in);

        String apple = "apple";
        String banana = "banana";
        String grape = "grape";
        String blueberry = "blueberry";
        String orange = "orange";

        String[] arr = {"apple", "banana", "grape", "blueberry", "orange"};

        String a = sc.next();
        int cnt = 0;
        for (int i = 0; i < 5; i++) {
            if (String.valueOf(arr[i].charAt(2)).equals(a)) {
                System.out.println(arr[i]);
                cnt++;
            } else if (String.valueOf(arr[i].charAt(3)).equals(a)) {
                System.out.println(arr[i]);
                cnt++;
            }
            
        }   
        System.out.print(cnt);

    }
}