import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String seats = sc.next();

        char[] seatsArr = seats.toCharArray();
        
        int maxDistance = 0;
        int startIdx = 0;
        int endIdx = 1;
        int maxStartIdx = 0;
        int maxEndIdx = 1;


        for (int i = 1; i < n; i++) {
            char seat = seatsArr[i];

            if (seat == '1') {
                endIdx = i;
                if (endIdx - startIdx > maxDistance) {

                    maxDistance = endIdx - startIdx;
                    maxStartIdx = startIdx;
                    maxEndIdx = endIdx;
                }

                startIdx = i;
            }
        }

        
        int minDistance1 = Integer.MAX_VALUE;
        int minDistance2 = Integer.MAX_VALUE;
        int minDistance3 = Integer.MAX_VALUE;
        // 처음이 1이 아닐때 
        if (seatsArr[0] != '1') {
            // 1을 처음에 넣는다.
            seatsArr[0] = '1';
            // 다시 최대 거리를 구한다.
            boolean firstCheck = false;
            startIdx = 0;
            for (int i = 0; i < n; i++) {
                char seat = seatsArr[i];

                if (seat == '1') {
                    if (!firstCheck) {
                        firstCheck = true;
                        startIdx = i;
                        continue;
                    }
                    endIdx = i;
                    minDistance1 = Math.min(minDistance1, endIdx - startIdx);

                    startIdx = i;
                }
            }
            seatsArr[0] = '0';

            // 마지막이 1이 아닐떄
            if (seatsArr[n-1] != '1') {
                // 마지막에 1을 넣는다.
                seatsArr[n-1] = '1';
                // 다시 최대 거리를 구한다.
                firstCheck = false;
                startIdx = 0;
                for (int i = 0; i < n; i++) {
                    char seat = seatsArr[i];

                    if (seat == '1') {
                        if (!firstCheck) {
                            firstCheck = true;
                            startIdx = i;
                            continue;
                        }
                        endIdx = i;
                        minDistance2 = Math.min(minDistance2, endIdx - startIdx);

                        startIdx = i;
                    }
                }
                seatsArr[n-1] = '0';
            } else {
                minDistance2 = 0;
            }

            // 처음과 마지막이 1일때 (이든 아니던 해봐야 하는 순서임)
            // 이 때에도 처음과 마지막이 1이 아닐때를 나누어야 한다.
            // 가장 먼 거리를 둔 인덱스들 사이에 1을 넣는다.
            seatsArr[(maxEndIdx+maxStartIdx) / 2] = '1';
            System.out.println(maxEndIdx + " " + maxStartIdx);

            // 다시 최대 거리를 구한다.
            firstCheck = false;
            startIdx = 0;
            for (int i = 0; i < n; i++) {
                char seat = seatsArr[i];

                if (seat == '1') {
                    if (!firstCheck) {
                        firstCheck = true;
                        startIdx = i;
                        continue;
                    }
                    endIdx = i;
                    minDistance3 = Math.min(minDistance3, endIdx - startIdx);

                    startIdx = i;
                }
            }
            // seatsArr[(maxEndIdx+maxStartIdx) / 2] = '0';
            
        } else {
            minDistance1 = 0;

            // 마지막이 1이 아닐떄
            if (seatsArr[n-1] != '1') {
                // 마지막에 1을 넣는다.
                seatsArr[n-1] = '1';
                // 다시 최대 거리를 구한다.
                startIdx = 0;
                for (int i = 1; i < n; i++) {
                    char seat = seatsArr[i];

                    if (seat == '1') {
                        endIdx = i;
                        minDistance2 = Math.min(minDistance2, endIdx - startIdx);

                        startIdx = i;
                    }
                }
                seatsArr[n-1] = '0';
            } else {
                minDistance2 = 0;
            }


            // 처음과 마지막이 1일때 (이든 아니던 해봐야 하는 순서임)
            // 이 때에도 처음과 마지막이 1이 아닐때를 나누어야 한다.
            // 가장 먼 거리를 둔 인덱스들 사이에 1을 넣는다.
            seatsArr[(maxEndIdx+maxStartIdx) / 2] = '1';

            // 다시 최대 거리를 구한다.
            startIdx = 0;
            for (int i = 1; i < n; i++) {
                char seat = seatsArr[i];

                if (seat == '1') {
                    endIdx = i;
                    minDistance3 = Math.min(minDistance3, endIdx - startIdx);

                    startIdx = i;
                }
            }
            // seatsArr[(maxEndIdx+maxStartIdx) / 2] = '0';
        }
        

        
        
        
        
        
        System.out.print(Math.max(minDistance1, Math.max(minDistance2, minDistance3)));
    }
}

// 문제
// 좌석 간의 거리가 필요
// 한 명을 더 받을 것임
// 원래 자리는 그대로 두고, 최대한 거리를 두면서 자리배치를 할 예정
// 거리 = 두 사람의 떨어진 거리
// 모든 좌석 개수 N
// 처음은 1이 주어짐. 마지막이 0이 아닐 수 있음.

// 요구사항
// 한 명을 더 넣었을 때의 가장 가까운 사람들의 최소거리를 구하라. => 가장 먼 사람을 찾는다 -> 그 사이에 사람을 넣는다. -> 가장 가까운 사람의 거리를 추출한다. -> 그 중에 가장 큰 값을 구해야 한다.

// 이해
// 가장 먼 거리를 구한다.
// 그 사이에 사람을 넣는다.
// XXX 마지막이 1이 아닌경우, 마지막 뒤에 1을 넣는다고 생각한다. XXX
// 마지막이 1이 아닌 경우, 마지막에 1을 넣었을때와 안 넣었을 때를 분기하여 정한다.
// 

// 구현
// 일단 가장 먼 길이를 구해야 한다. (0 초기값)
// 두번째부터 1임을 체크한다.
// 1이면 마지막인덱스에 i를 넣는다.
// 마지막 인덱스(초기값1) - 스타트 인덱스(초기값0) = 새로운거리 가 곧 거리이다.
// 만약 새로운거리가 이전거리(초기값 MAX)보다 크다면 이전거리에 새로운거리를 대입하고,
// 스타트인덱스와 마지막인덱스를 별도의 변수에 저장한다. (minStartIdx, minEndIdx)
// 후에 스타트인덱스에 i를 넣는다. (엔드인덱스는 조건 충족때마다 갱신되니, 스타트인덱스는 미리 갱신해놓아야 함.)

// POC
// 처음에 1이 없는 경우 로직 자체가 달라짐.
// 있는 경우와 없는 경우를 나눠서 또 분기를 해야함.
// 1이 없는 경우는, 1을 처음에 넣거나, 마지막에 넣거나, 가장 먼 것 사이에 넣는다.
// 1이 있는 경우는, 마지막에 넣거나, 가장 먼 것 사이에 넣는다.

// if (1이 처음에 없는 경우) {
//    1을 처음에 넣는다.
//    마지막에 넣는다.
//    가장 먼 것 사이에 넣는다.
// } else if (1이 처음에 있는 경우) {
//    마지막에 넣는다.
//    가장 먼 것 사이에 넣는다.
// }