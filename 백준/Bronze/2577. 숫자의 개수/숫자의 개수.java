import java.util.*;


class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();



        int m = a*b*c;

        int[] arr = new int[10];
        
        
        while (m > 0) {
            int digit = m % 10;
            arr[digit]++;
            m /= 10;
        }


        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }


    }
}