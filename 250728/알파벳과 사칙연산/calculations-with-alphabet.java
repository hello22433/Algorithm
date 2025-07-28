import java.util.*;
public class Main {
    static int a,b,c,d,e,f = 0;
    static int[] alphabetValue = new int[6];
    static Map<Character, Integer> alphabetIndex = new HashMap<>();

    static String expression;
    static int len;
    static Character[] arr;
    static int maxVal = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        expression = sc.next();
        // Please write your code here.
        len = expression.length();
        arr = new Character[len];

        for (int i = 0; i < len; i++) {
            arr[i] = expression.charAt(i);
        }

        alphabetIndex.put('a', 0);
        alphabetIndex.put('b', 1);
        alphabetIndex.put('c', 2);
        alphabetIndex.put('d', 3);
        alphabetIndex.put('e', 4);
        alphabetIndex.put('f', 5);

        dfs(0);
        System.out.print(maxVal);
        
    }

    public static void dfs(int depth) {
        if (depth == 6) {

            int preCalcul = alphabetValue[alphabetIndex.get(arr[0])];
            for (int i = 2; i < len; i+=2) {
                char opperator = arr[i-1];
                char opperand = arr[i];
                
                if (opperator == '+') {
                    preCalcul += alphabetValue[alphabetIndex.get(opperand)];
                } else if (opperator == '-') {
                    preCalcul -= alphabetValue[alphabetIndex.get(opperand)];
                } else if (opperator == '*') {
                    preCalcul *= alphabetValue[alphabetIndex.get(opperand)];
                }
            }

            maxVal = Math.max(maxVal, preCalcul);
            return;
        }

        
        for (int val = 1; val <= 4; val++) {
            alphabetValue[depth] = val;
            dfs(depth+1);
        }
    }
}



// a ~ f , 연속하지 않고 항상 번갈아가며 주어짐. 시작과 마지막에는 반드시 알파벳 입력됨
// + - * 
// 연산은 무조건 앞->뒤
// 각 소문자 알파벳에 1~4 적절한 수
// 
// a b c d e f 에 1 2 3 4 를 번갈아가며 모두 넣어야 한다.
// a에 1234, b에1234 ...

// 길이는 무조건 홀수. 
// 연산자의 인덱스는 홀수
// 피연산자의 인덱스는 짝수

// +2를 하며 반복문을 실행하고, 첫번째를 제외한 피연산자에서는 그 전 연산자를 사용하고 그 전 결과계산결과와의 계산을 한다.
// 그럼 이제 피연산자에 어떻게 숫자를 넣을 것인가?
// a에 1을 넣고 2를 넣고...