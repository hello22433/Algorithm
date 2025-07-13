import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        char[] arr = A.toCharArray();
        int len = A.length();
        int minCntLengthSum = Integer.MAX_VALUE;

        for (int t = 0; t < len; t++) {

            char lastValBeforeRotate = arr[len-1];
            for (int i = len-1; i >= 1; i--) {
                arr[i] = arr[i-1];
            }
            arr[0] = lastValBeforeRotate;

            char firstValAfterRotate = arr[0];
            int cnt = 1;
            int totalCntLengthSum = 0;
            for (int i = 1; i < len; i++) {
                if (arr[i] != firstValAfterRotate) {
                    totalCntLengthSum += String.valueOf(cnt).length() + 1;

                    firstValAfterRotate = arr[i];
                    cnt = 1;
                } else {
                    cnt++;
                }
            }

            totalCntLengthSum += String.valueOf(cnt).length() + 1;

            minCntLengthSum = Math.min(minCntLengthSum, totalCntLengthSum);
        }
        
        System.out.print(minCntLengthSum);
    }
}


// 문자가 원상태가 되기까지 한 바퀴를 돌려야 한다.
// 즉, 문자열의길이 만큼 밀어야 한다. (밀고 검사하는 식으로 로직을 짤 것이라면)
// 밀때마다, 첫번쨰 값을 저장하고, 두번째부터 순회하는데 첫번째 값과 다르면, 카운트++
// 순회가 끝나면 총카운트 값을 최소화한다.