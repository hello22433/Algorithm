import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[] countArr = new int[100];

        for (int i = 0; ; i++) {
            int num = sc.nextInt();
            if (num==0) break;
            countArr[num/10]++; 
        }

        for (int i = 1; i<=9; i++) {
            System.out.println(i + " - " + countArr[i]);
        }
    }
}
