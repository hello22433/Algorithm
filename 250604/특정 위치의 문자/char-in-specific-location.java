import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // int a = sc.nextInt();
        // int b = sc.nextInt();
        // 나머지는 0부터 1000  

        String[] arr = {"L", "E", "B", "R", "O", "S"};
        String n = sc.next();

        for (int i = 0; i < arr.legnth; i++) {
            if (n.equals(arr[i])) {
                System.out.print(i);
                return;
            }
        }
        System.out.print("None");
    }
}
