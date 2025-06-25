import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        // Please write your code here.
        int minDistance = Integer.MAX_VALUE;

        
        // A->B
        // 그냥 걸어간다.
        minDistance = Math.min(minDistance, Math.abs(B-A));
        // A->x->y->B
        minDistance = Math.min(minDistance, Math.abs(x-A)+Math.abs(y-B));
        // A->y->x->B
        minDistance = Math.min(minDistance, Math.abs(y-A)+Math.abs(x-B));

        System.out.print(minDistance);
    }
}

// 문제
// A->B 걸어감
// 순간이동 1번 : x->y , y->x
// 걸어간 거리를 최소한

// 이해
// A<B 이면 x와 y의 
// 최솟값이 A보다 작은 경우 , 더 큰 경우 -> 
// 최댓값이 B보다 큰 경우, 더 작은 경우 -> 
// 경우의 수가 4가지로 나뉘므로 모든 수를 고려해본다. 
// 그냥 걸어간다, A->x->y->B, A->y->x->B