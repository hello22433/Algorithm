import java.util.*;


class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
//        int c = sc.nextInt();

        int ra = reverse(a);
        int rb = reverse(b);

        System.out.println(Math.max(ra,rb));



    }
    
    private static int reverse(int num) {
        int result = 0;
        
        while (num > 0) {
            result = result * 10 + num % 10;
            num /= 10;
        }
        
        return result;
    }
}