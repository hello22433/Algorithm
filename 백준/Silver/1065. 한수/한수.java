
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 0;
        if (String.valueOf(N).length() <= 2) {
            System.out.println(N);
            return;
        } else {
            count = 99;
        }

        // 2번째 자리수까지는 모두 고려하였으니 100부터 시작한다.
        for (int i = 100; i <= N; i++) {
            boolean imTrue= true;
            int iLength = String.valueOf(i).length();
            int firstTolerance = (int) String.valueOf(i).charAt(0) - (int) String.valueOf(i).charAt(1) ;
            for (int j = 1; j < iLength-1; j++) {
                int Tolerance = (int) String.valueOf(i).charAt(j) - (int) String.valueOf(i).charAt(j+1) ;
                if (firstTolerance != Tolerance) {
                    imTrue = false;
                    break;
                }
            }
            if (imTrue) {
                count++;
            }
        }
        System.out.println(count);
    }
}

// X의 각 자리가 등차수열 -> X는 한수
// 연속된 두 개의 수의 차이가 일정한 수열.
// 1 <= X <= N. 한수인 X 몇 개인가?

// 두 자리까지는 무조건 등차수열 (즉 100이상이면 99개는 일단 확보)
// 뒤에서 앞에걸 빼든, 앞에서 뒤에걸 빼든 일정한 방향으로 연산이 이루어져야 한다.
// 1부터 N까지. 각각의 자리수를 탐색하면서 앞에서부터 뒤에걸 뺀다.
// 맨 처음 공차를 입력하고, 만약 다른 공차가 나올 경우 break;을 한다.
// 만약 안 나오면 그대로 count +=1 ; 한다
// count 출력