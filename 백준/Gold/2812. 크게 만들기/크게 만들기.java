

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        String num = sc.next();

        Stack<Character> stack = new Stack<>();
        int remove = 0;
        for (int i = 0; i < N; i++) {
            char ch = num.charAt(i);

            while (!stack.isEmpty() && stack.peek() < ch && remove < K) {
                stack.pop();
                remove++;
            }

            stack.push(num.charAt(i));
        }

        while (remove < K) {
            stack.pop();
            remove++;
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : stack) {
            sb.append(ch);
        }

        System.out.println(sb.toString());
    }
}

// 앞자리에 큰 숫자를 남기는게 관건
// 앞자리에서 하나씩 축적하다가 큰 수가 있으면 삭제한다.
// 맨앞부터 하나씩 탐색한다. 탐색을 시작하는 부분부터 K 번째까지 하나씩 탐색하다가
// 만약 더 큰값이 보이면 K에서 삭제하는만큼 K에서 해당 수만큼 빼서 K를 갱신하고,
//
// 앞에서부터 탐색하며 더 큰값이 나오면 앞값을 삭제한다.
// 삭제하지 않았다는 것은 앞값이 뒷값보다 컸다는 것.
// 탐색했을떄 K개 미만의 수를 삭제하게 될 수 있다.
// 즉, 뒤의 값이 확정이 되지 않기에 앞의 값들을 고려해야 한다.
// 뒤에서 더 큰값을 발견하게 되면 차례로 마지막에 저장된 앞의 값을 비교하며 삭제해야 한다. -> 왜냐하면 마지막에 저장된 값이 더 작은 값이기 때문
// 삭제하고 나서도 그다음에 저장된 값에 대해서도 값비교를 해야한다. 스택을 활용하여 peek값을 반복비교하며 삭제
// 시간복잡도 N+K
// 마지막에는 거꾸로 삭제해줘야 한다. K가 남은만큼.