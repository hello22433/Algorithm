import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        // Please write your code here.

        int[] sortedArr = Arrays.stream(arr).sorted().toArray();
        boolean[] visited = new boolean[n];
        int[] moveRecord = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[j] && arr[i] == sortedArr[j]) {
                    visited[j] = true;
                    moveRecord[i] = j+1;
                    break;
                }
            }
        }

        for (int i = 0; i < n; i++) 
            System.out.print(moveRecord[i] + " ");
    }
}

// 문제
// 양의 정수를 원소로 갖는 길이N의 수열.
// 수열을 오름차순 정렬했을 때,
// 각각의 위치에 있던 원소가 
// 어느 위치로 이동하는지?
// 동일한 원소라면, 먼저 입력으로 주어진 원소가 더 앞으로!

// 이해
// 정렬을 하고 나서, 
// 원래배열을 하나씩 돌면서 정렬배열에서 찾는다.
// 중요한건 boolean[]을 만들어서 정렬배열에서 찾을 때마다 똑같은 인덱스에 true로 방문했다고 해주어야 한다.
// 이후에 방문하지 않은 인덱스에만 방문할 수 있도록 한다. 
// 순서대로 방문하지 않은 인덱스에 방문하기에 자동으로 같은 원소일 경우 먼저 입력으로 주어진 원소가 더 앞에 위치하게 된다.
// 새로운 배열에 저장을 할때는 인덱스+1로 순서를 만든다.

// 해결
// 순서를 저장할 새로운 배열 생성 int[] moveLocation
// 방문을 저장할 새로운 배열 생성 boolean[] visited => 1부터 1000000까지 저장해야 한다. 길이 1000001 
// !visited[j] && arr[i] == sortedArr[j] 방문을 j인덱스(sortedArr의 인덱스)에 했으면 다시 방문할 수 없다