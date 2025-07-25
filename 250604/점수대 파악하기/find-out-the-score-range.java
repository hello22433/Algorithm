import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[] countArr = new int[101];

        for (int i = 0; ; i++) {
            int num = sc.nextInt();
            if (num==0) break;
            countArr[num/10]++; 
        }

        for (int i = 10; i>=1; i--) {
            System.out.println(i+"0" + " - " + countArr[i]);
        }
    }
}
