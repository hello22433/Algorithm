import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // Please write your code here.

        int wifiCnt = 0;
        for(int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                i += m + m;
                wifiCnt++;
            }
        }
        System.out.print(wifiCnt);
        
    }
}

// 문제
// 0과 1로만 이루어진 n개의 숫자
// x=1 인 위치부터 x=n 까지 각 정수 지점 위치에 사람들이 살고 있는지에 대한 여부
// 1이면 살고있음, 0이면 안 살고 있음
// 와이파이 설치하려고 함. 설치한 위치부터 거리 m이내에 있는 사람 모두 사용 가능. 정수 위치면 어디든 설치 가능
// 
// 요구사항
// 모든 사람이 와이파이 사용하도록하는 '최소 와이파이 수'
//
// 이해
// 인덱스 차이의 절대값이 곧 거리 <= m 일때 와이파이 사용 가능하다.
// 순회할때 1을 발견하면 해당 위치에서 m 떨어진 곳에 와이파이를 설치할 것임.(최대거리)
// (인덱스+m)인 인덱스에 와이파이 설치. 
// 이후 해당 와이파이 범위를 벗어난 곳(인덱스+m에서부터 m떨어진곳이 와이파이가 끝까지 닿는곳)에서부터 다시 순회를 시작할 것임. (인덱스+m+m+1)
// 