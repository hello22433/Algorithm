import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        // Please write your code here.
        
        if (Math.abs(b-a) + Math.abs(b-c) == 2 || Math.abs(a-b) + Math.abs(a-c) == 2 || 
            Math.abs(c-a) + Math.abs(c-b) == 2) {
            System.out.print(0);
        } else if (Math.abs(a-b) == 2 || Math.abs(b-c) == 2) {
            System.out.print(1);
        } else {
            System.out.print(2);
        }
    }
}


// 문제
// 3명의 일직선 위의 사람들
// 방법 : 양 끝쪽에 있는 사람 중 한 사람 선택
//  -> 남은 두 사람 사이로 이동
// 목적 : 세 사람이 서 있는 위치가 연속된 숫자 만들기 -> 이동횟수 최소화
// 순서는 상관 없이 연속된 숫자면 된다.
// 사이로 들어갈 때는 그 사이값 중 하나로 들어가야 한다
// 

// 이해
// 양 끝 쪽에서 하나를 고르는 기준 : 중간 수와 차이가 더 작은 수를 골라야 한다 why? 그래야 차이를 줄여나갈때 유리하다
// 사이에 넣을 때 숫자를 정하는 기준 : 
// 한 수를 골라서 하나의 끝의 수와 2차이가 나는 수를 집어놓고, 기준이 되지 않은 나머지 끝 수를 그 사이에 넣으면 무조건 2번이 아닌가?
// 모두 연속되지 않는 경우 -> 2
// 두 개가 연속되는 경우 -> 2 (그 사이에 값이 들어갈 수 없으므로)
// 두 개가 2차이가 나는 경우 -> 1 (그 사이 값으로 만들면 되므로)
// 세 개가 연속되는 경우 -> 0