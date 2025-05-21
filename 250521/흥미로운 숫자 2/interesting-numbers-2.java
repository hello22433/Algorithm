// import java.util.Scanner;

// public class Main {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int x = sc.nextInt();
//         int y = sc.nextInt();
//         // Please write your code here.


//         int cnt = 0;
//         for (int i = x; i <= y; i++) {
//             String strI = String.valueOf(i);
//             char firstIChar = strI.charAt(0);
//             char secondIChar = strI.charAt(1);

//             int diffCnt = 0;
//             int diffCnt2 = 0;
//             for (int j = 1; j < strI.length(); j++) {
//                 if (strI.charAt(j) != firstIChar) {
//                     diffCnt++;
//                 }
//                 if (strI.charAt(j) != secondIChar) {
//                     diffCnt2++;
//                 }
//             }

//             // 첫째 자리가 다른 수일때, 둘째 자리와 그 이후의 수는 다 같아야 한다. 
//             if (diffCnt == 1 || (diffCnt == strI.length()-1 && diffCnt2 == 0)) cnt++;
//         }

//         System.out.print(cnt);
//     }
// }

// // 정확히 한 자리만 다른 숫자



import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();

        int cnt = 0;
        for (int i = x; i <= y; i++) {
            String str = String.valueOf(i);

            for (int j = 0; j < str.length(); j++) {
                char base = str.charAt(j);
                int diff = 0;

                for (int k = 0; k < str.length(); k++) {
                    if (str.charAt(k) != base) {
                        diff++;
                    }
                }

                if (diff == 1) {
                    cnt++;
                    break; // 이미 만족한 수는 중복 계산 안 함
                }
            }
        }

        System.out.print(cnt);
    }
}
