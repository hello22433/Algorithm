import java.util.*;
public class Main {

    static int n;
    static char[] operator = {'+', '-', '2', '3'};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        // Please write your code here.
        int minMoves = bfs(n);
        System.out.print(minMoves);
    }

    public static int bfs(int n) {

        int moves = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        if (n == 1) return 0;

        while (!q.isEmpty()) {
            moves++;
            int qSize = q.size();

            for (int t = 0; t < qSize; t++) {
                int curVal = q.poll();
                
                for (int i = 0; i < 4; i++) {
                    int nVal = curVal;

                    if (operator[i] == '+') {
                        nVal += 1;
                    } else if (operator[i] == '-') {
                        nVal -= 1;
                    } else if (operator[i] == '2') {
                        if (nVal % 2 == 0) nVal /= 2;
                    } else if (operator[i] == '3') {
                        if (nVal % 3 == 0) nVal /= 3;
                    }

                    if (nVal == 1) return moves;

                    q.add(nVal);
                }
            }
            
        }

        return -1;
    }
}

// N
// 4가지 연산 -> 연산의 횟수 최소화하여 1만들기
// -1 +1 /2 /3
//
// 모든 순열을 dfs로 구한다
// 