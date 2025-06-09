import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str1 = sc.nextLine();
        
        String[] arr = {"apple", "banana", "grape", "blueberry", "orange"};
        
        int cnt = 0;
        for (int a = 0; a < 5; a++) {
            String str = arr[a];
            for (int i = 2; i < 4; i++) {
                if (str.charAt(i) == str1.charAt(0)) {
                    cnt++;
                    System.out.println(str);
                    break;
                }
            }
        }
        System.out.print(cnt);
        
    }
}
