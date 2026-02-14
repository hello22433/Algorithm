import java.util.*;


class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();



        int m = a*b*c;

        String sm = String.valueOf(m);
        int[] arr = new int[10];
        for (int i = 0; i < sm.length(); i++) {
            int num = sm.charAt(i) - '0';
            arr[num]++;
        }
        
        
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }


    }
}