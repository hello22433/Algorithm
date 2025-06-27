import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = n-1; i >= 0; i--) {
            if (arr[i] < arr[i-1]) {
                System.out.print(i-1+1);
                return;
            }
        }
        System.out.print(0);
    }
}

// 오름차순으로 정렬해야 한다.
// 앞에서 하나씩 빼서 끼워넣을 수 있다.
// 그럼 이미 오름차순인 것들은 냅둬도 된다.
// 어차피 앞에서 빼서 아무 곳에나 넣을 수 있으니까!
// 그럼 오름차순이 아닌 숫자 앞에 다른 숫자들이 있으면 어떻게 할까?
// 그럼 그 숫자들도 어차피 다 뒤로 보내야 한다.
// 그럼 결국 원하는 자리로 모두 간다는 뜻이므로 오름차순이 아닌 숫자를 옮길때 모두 옮겨진다.
// 즉 뒤에서부터 체크했을 때, 오름차순이 아닌 수의 인덱스+1(1based)만큼 원소들이 움직이게 된다.
