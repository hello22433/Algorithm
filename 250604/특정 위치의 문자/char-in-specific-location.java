import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         

        String[] arr = {"L", "E", "B", "R", "O", "S"};
        String n = sc.next();

        for (int i = 0; i < arr.length; i++) {
            if (n.equals(arr[i])) {
                System.out.print(i);
                return;
            }
        }
        System.out.print("None");
    }
}
