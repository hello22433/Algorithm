import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] countArr = new int[10];

        for (int i = 0; i < n; i++) {
            countArr[sc.nextInt()]++; 
        }

        for (int i = 1; i<=9; i++) {
            System.out.println(countArr[i]);
        }
    }
}
