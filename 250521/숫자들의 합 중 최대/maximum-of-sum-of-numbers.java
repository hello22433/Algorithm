import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        // Please write your code here.

        int maxSum = Integer.MIN_VALUE;
        for (int i = x; i <= y; i++) {
            String strI = String.valueOf(i);
            int sum = 0;
            for (int j = 0; j < strI.length(); j++) {
                sum+= Character.getNumericValue(strI.charAt(j));
            }
            maxSum = Math.max(maxSum, sum);
        }
        System.out.print(maxSum);
    }
}


//