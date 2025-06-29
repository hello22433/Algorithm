import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] line = new int[101];
        int n = sc.nextInt();

        int maxPoint = Integer.MIN_VALUE;
        int minPoint = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();
            minPoint = Math.min(x1,minPoint);
            maxPoint = Math.max(maxPoint,x2);

            for (int j = x1; j <= x2; j++) {
                line[j] += 1;
            }
        }

        int minPointEndPoint = 0;
        int minPointCnt = 0;
        boolean checkZeroCntIdx = false;
        for (int i = minPoint; i <= maxPoint; i++) {
            if (line[i] >= 2) {
                minPointEndPoint = i;
                break;
            }
            if (line[i] == 0) {
                checkZeroCntIdx = true;
                continue;
            }
            if (checkZeroCntIdx && line[i] != 0) {
                minPointEndPoint = i;
                break;
            }
            minPointCnt++;
        }

        int maxPointEndPoint = 0;
        int maxPointCnt = 0;
        checkZeroCntIdx = false;
        for (int i = maxPoint; i >= minPoint; i--) {
            if (line[i] >= 2) {
                maxPointEndPoint = i;
                break;
            }
            if (line[i] == 0) {
                checkZeroCntIdx = true;
                continue;
            }
            if (checkZeroCntIdx && line[i] != 0) {
                maxPointEndPoint = i;
                break;
            }
            maxPointCnt++;
        }
        
        if (maxPointCnt > minPointCnt) {
            System.out.print(maxPointEndPoint - minPoint);
        } else {
            System.out.print(maxPoint - minPointEndPoint);
        }
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