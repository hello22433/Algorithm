
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int fiveQuoat = N / 5;
        int fiveRemain = N % 5;
        int threeQuoat = fiveRemain / 3;
        int threeRemain = fiveRemain % 3;

        if (threeRemain == 0) {
            System.out.print(fiveQuoat + threeQuoat);
        } else {
            for (int fiveQuantity = fiveQuoat; fiveQuantity >= 0; fiveQuantity--) {
                int newN = N - 5*fiveQuantity;
                threeQuoat = newN / 3;
                threeRemain = newN % 3;

                if (threeRemain == 0) {
                    System.out.print(fiveQuantity + threeQuoat);
                    break;
                }
            }

            if (threeRemain != 0) {
                System.out.print(-1);
            }
        }
    }
}


// N을 3과 5로 나누어서 가장 적은 몫을 만들어야 한다.
// 5와 3의 비율을 조절하면서 최소몫을 구한다.
// 나누어지면 min으로 최소몫 갱신.
// 처음에 5로 나눈 값으로 비율의 처음을 정한다.
// 5로 나누고 3으로 나눈다.
// 만약 나머지가 없으면 리턴한다.
// 만약 안 나누어떨어지면 몫을 저장하고 5의 개수로 지정한다.
// 5의 개수를 하나씩 내리면서 3으로 나눠 나누어떨어질때까지 나눈다.
// N - 5의개수 * 5 을 3으로 나눈다.
// 만약 안 나누어떨어지면 -1을 출력
