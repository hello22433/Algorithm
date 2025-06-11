import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String a = sc.next();
        char[] charArr = a.toCharArray();
        charArr[1] = 'a';
        charArr[charArr.length-2] = 'a';
        System.out.print(String.valueOf(charArr));

        // System.out.print(a.substring(0,1) + "a" + a.substring(2, a.length()-2) + "a" + a.substring(a.length()-1));
    }
}