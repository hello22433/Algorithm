import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String seats = sc.next();
        // Please write your code here.

        int distance = -1;
        int startIdx = 0;
        int endIdx = 1;
        int minStartIdx = 0;
        int minEndIdx = 1;

        for (int i = 1; i < seats.length(); i++) {
            char seat = seats.charAt(i);
            if (seat == '1') {
                endIdx = i;
                // System.out.println(startIdx + " " + endIdx);

                if (endIdx - startIdx > distance) {
                    // 새로 찾은 거리가, 기존 거리보다 멀다면 그 사이에 놓아야 하므로 
                    // 둘 인덱스를 기록해야 한다. 
                    // 최종적으로 둘 인덱스를 더하고 나누기 2하면 된다.
                    minStartIdx = startIdx;
                    minEndIdx = endIdx;
                    distance = endIdx - startIdx;
                } else {
                    // 현상유지
                }
                
                startIdx = i;
            } else {
                // 현상유지
            }
        }

        char[] seatsArr = seats.toCharArray();
        seatsArr[(minStartIdx+minEndIdx) / 2] = '1';
        seats = String.valueOf(seatsArr);

        int minDistance = Integer.MAX_VALUE;
        startIdx = 0;
        endIdx = 1;
        
        for (int i = 1; i < seats.length(); i++) {
            char seat = seats.charAt(i);
            if (seat == '1') {
                endIdx = i;
                minDistance = Math.min(minDistance, endIdx - startIdx);
                startIdx = i;
            } else {
            } 
        }

        // System.out.print(seats);
        System.out.print(minDistance);
    }
}

// 문제
// 1명 더 받을 것
// 이용자들 간의 거리를 최대화
// 양쪽 끝자리는 항상 1
// 최소 3명

// 요구
// 가장 가까운 두 사람 간의 거리를 최대화한 거리
// => 가장 먼 거리에 있는 두 사람의 중간에 새로운 사람을 넣으면, 최대한의 거리두기가 됨.

// 이해
// 가장 먼 거리를 가진 사람을 찾는다. => 또다른 1을 발견할 때까지 카운트를 센다. 1을 발견하면 카운트가 곧 0의 개수.
// 카운트는 0으로 초기화(1에 도착했다는 것은 찾은 0의 개수가 0이므로)
// 2번 째 인덱스부터 시작할 것임. 그러므로 제로카운트가 1에서 시작.
// 1을 찾으면 제로 카운트를 비교 해야한다. 제로 카운트가 가장 많은 사람이 가장 먼 사람인 것이므로, 시작 인덱스와 끝 인덱스를 지정해야 한다.
// 즉, 