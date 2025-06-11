import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String S = sc.next();
        char[] sArr = S.toCharArray();
        int Q = sc.nextInt();

        for (int i = 0; i < Q; i++) {
            int num = sc.nextInt();
            
            if (num == 1) {
                int a = sc.nextInt() -1; // 인덱스로 변환
                int b = sc.nextInt() -1; 

                char temp = sArr[a];
                sArr[a] = sArr[b];
                sArr[b] = temp;
                System.out.println(String.valueOf(sArr));
            } else if (num == 2) {
                char x = sc.next().charAt(0);
                char y = sc.next().charAt(0);

                for (int j = 0; j < sArr.length; j++) {
                    if (sArr[j] == x) {
                        sArr[j] = y;
                    }
                }

                System.out.println(String.valueOf(sArr));
            }
        }
    }
}