import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int a = sc.nextInt();
        int b = sc.nextInt();
        int[] arr= new int[102];
        arr[1] = a;
        arr[2] = b;
            System.out.print(arr[1] + " ");
            System.out.print(arr[2] + " ");

        for (int i = 3; i <= 10; i++) {
            arr[i] = arr[i-1] + 2*arr[i-2];
            System.out.print(arr[i] + " ");
        }

        
    }
}
