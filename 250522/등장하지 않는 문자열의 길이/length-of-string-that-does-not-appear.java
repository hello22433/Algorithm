import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        // Please write your code here.

        for (int i = 1; i <= n; i++) {
            
            // if (i > n/2) {
            //     System.out.print(i);
            //     return;
            // }
            
            // 시작점을 정한다
            boolean isOnlyOne = true;
            outer : for (int j = 0; j < n; j++) {

                if (j+i-1 > n-1) break;
                // 기준을 정한다.
                String base = str.substring(j, j+i);

                int equalCnt = 0;
                for (int k = 0; k < n; k++) {
                    if (k+i-1 > n-1) break;
                    if (str.substring(k, k+i).equals(base)) equalCnt++;
                    if (equalCnt > 1) {
                        isOnlyOne = false;
                        break outer;
                    }
                }
            }
            if (isOnlyOne) {
                System.out.print(i);
                return;
            }
            // 같은게 나오면 바로 다음 개수로 넘어간다. break
            // 끝까지 안 나오면 
        }
    }
}


// 중복이 발생하지 않는 연속 부분 문자열의 최소 길이
// 1개부터 N개까지 모두 체크해야 한다. -> 몇개를 할 건지 정한다.
// 정해진 숫자만큼 정한다. (기준을 정한다)
// str의 처음부터 정해진 숫자만큼 돌면서 같은 게 나오면 equalCnt++한다
// equalCnt 가 1이면 i를 출력하고 return한다.