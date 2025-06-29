import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] line = new int[101];
        int n = sc.nextInt();

        

        int[] arrX1 = new int[n];
        int[] arrX2 = new int[n];

        for (int i = 0; i < n; i++) {
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();
            arrX1[i] = x1;
            arrX2[i] = x2;

            for (int j = x1; j <= x2; j++) {
                line[j] += 1;
            }
        }

        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            
            int[] copyedLine = Arrays.copyOfRange(line, 0, line.length);
            for (int j = arrX1[i]; j <= arrX2[i]; j++) {
                copyedLine[j] -= 1;
            }

            int maxPoint = Integer.MIN_VALUE;
            int minPoint = Integer.MAX_VALUE;
            for (int j = 0; j <= 100; j++) {
                if (copyedLine[j] != 0) {
                    maxPoint = Math.max(maxPoint, j);
                    minPoint = Math.min(minPoint, j);
                }
            }
            minDistance = Math.min(minDistance, maxPoint - minPoint);
        }
        System.out.print(minDistance);
    }
}

// 문제
// 1차원 직상 선분이 N개

// 요구사항
// 하나의 선분을 적절히 제거 -> 나머지 N-1 개의 선분을 모두 포함 하는 가장 짧은 선분의 길이를 최소!!
// 선분의 길이는 x좌표간의 차이

// 이해
// 가장 작고 큰점을 기준으로 삭제해야 한다.
// OR 최대한 겹쳐지지 않은 곳을 삭제해야 한다.
// 가장 작은점으로부터 세다가 (길이를 더해가다가) 2이상이 나오면 (겹치면) 카운트를 종료 (해당 점 저장)
// 반대로 가장 큰점으로부터 세다가 2이상이 나오면 카운트를 종료 (해당 점 저장)
// 카운트를 더 큰 걸 선별한다.
// 더 큰 쪽이 삭제되어야 한다. 더 카운트가 큰 쪽의 점을 가진 선을 삭제한다. => 만약 더 큰쪽이 가장 큰점쪽이면 큰점쪽의 카운트가 끊긴점
// 끊긴점 - 가장작은점 
// 만약 더 작은쪾이 가장 큰 점 쪾이면, 가장큰점 - 끊긴점

// 선분에 다 표시해놓고, 하나씩 뺀다
// 빼놓고 가장 긴점과 가장 작은 점을 측정하고, 