import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[] countArr = new int[10];

        for (int i = 0; i < 10; i++) {
            countArr[sc.nextInt()]++; 
        }

        for (int i = 1; i<=6; i++) {
            System.out.println(i + " - " + countArr[i]);
        }
    }
}
