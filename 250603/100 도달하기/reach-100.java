import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] arr= new int[102];
        arr[1] = 1;
        arr[2] = n;
            System.out.print(arr[1] + " ");
            System.out.print(arr[2] + " ");

        for (int i = 3; i < 102; i++) {
            arr[i] = arr[i-2] + arr[i-1];
            System.out.print(arr[i] + " ");
            if (arr[i] > 100) {
                break;
            }
        }

        
    }
}
