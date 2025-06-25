import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] arr = new char[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next().charAt(0);
        }
        // Please write your code here.

        int movingCnt = 0;
        char currentAlphabet = 'A';
        while ((int) currentAlphabet <= 65 + n - 1) {
            for (int i = 0; i < n; i++) {
                if (arr[i] == currentAlphabet) {
                    movingCnt += i - (currentAlphabet - 65);
                    // i에 있는 값을 currentAlphabet - 65 로 보내야 함
                    // 0부터 currentAlphabet - 65 전까지는 보존한다.
                    // i를 제외하고 : currentAlphabet - 65 부터 i 전까지 를 보존한다.
                    // i를 currentAlphabet - 65에 넣는다.
                    // currentAlphabet - 65 부터 i 전까지 와 i 후부터 더한다.
                    char[] copyArr1 = Arrays.copyOfRange(arr, 0, currentAlphabet - 65);
                    char[] copyArr2 = Arrays.copyOfRange(arr, currentAlphabet - 65, i);
                    char[] copyArr3 = Arrays.copyOfRange(arr, i+1, arr.length);

                    for (int j = 0; j < copyArr1.length; j++) {
                        arr[j] = copyArr1[j];
                    }

                    arr[copyArr1.length] = currentAlphabet;

                    for (int j = 0; j < copyArr2.length; j++) {
                        arr[j + copyArr1.length + 1] = copyArr2[j];
                    }

                    for (int j = 0; j < copyArr3.length; j++) {
                        arr[j + copyArr1.length + copyArr2.length +1] = copyArr3[j];
                    }

                    currentAlphabet += 1;
                    // break;
                }
                // for (int k = 0; k < n; k++)
                //     System.out.print(arr[k] + " ");
                // System.out.println();
                
            }
        

        }
        System.out.print(movingCnt);
    }
}


// 문제
// A부터 순서대로(순서 그대로 주어지는게 아니라 주어지는 알파벳이 ABC..로 주어진다는 것) N명의 사람이 주어진다.
// 인접한 두 사람의 위치를 바꾸는 행위만 가능.

// 요구사항
// 인접한 두 사람의 위치를 바꿔서 알파벳 순으로 줄을 세워라 => '가능한 최소 회수'를 구하라

// 이해 
// 하나씩 왼쪽으로 보내주면 된다. A의 인덱스를 찾고, 첫번째 인덱스를 뺀다. -> 뺀 값은 곧 이동한 횟수이므로 카운트에 더한다 -> 이하 반복
// 
