import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        int eeCnt = 0;
        int ebCnt = 0;
        
        for (int i = 0; i < str.length()-1; i++) {
            if (str.charAt(i)=='e') {
                if (str.charAt(i+1)=='e') {
                    eeCnt++;
                } else if (str.charAt(i+1)=='b') {
                    ebCnt++;
                }
            }
        }
        System.out.print(eeCnt + " " + ebCnt);
    }
}