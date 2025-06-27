import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] numbers = new int[N];
        int oddQuantites = 0;
        int evenQuantites = 0;

        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
            if (numbers[i]%2==0) {
                evenQuantites++;
            } else {
                oddQuantites++;
            }
        }
       
        boolean isEvenOrOdd = true;
        int cnt = 0;
        
        while (oddQuantites != 0 || evenQuantites != 0) {
            if (isEvenOrOdd) {
                if (evenQuantites == 0) {
                    if (oddQuantites >= 2) { 
                        oddQuantites-=2;
                        cnt++;
                        if (oddQuantites == 0) {
                            // cnt -1을 안 하는 이유는 새로 생기는 조합이 방금 생긴거지 합쳐지는 조합이 없기 때문이다.
                            System.out.print(cnt);
                            return;
                        }
                    } else if (oddQuantites == 1) { // 짝수는 없고, 홀수 한 개만 남았을 경우
                        System.out.print(cnt-1);
                        return;
                    } 
                    // else 는 odd가 하나도 없을 때인데 그 경우는 이미 위에서 걸러짐.
                } else {
                    evenQuantites--;
                    cnt++;
                    if (evenQuantites==0 && oddQuantites==0) {
                        System.out.print(cnt);
                        return;
                    }
                }
                
                isEvenOrOdd = false;
            } else {
                if (oddQuantites == 0) {
                    System.out.print(cnt);
                    return;
                } else {
                    oddQuantites--;
                    cnt++;
                    if (evenQuantites==0 && oddQuantites==0) {
                        System.out.print(cnt);
                        return;
                    }
                }

                
                isEvenOrOdd = true;
            }
        }
    }
}


// 문제
// N개의 수들이 주어짐. 전부 사용해야 함.
// 각 묶음으로 나눠야 함. 각각의 합을 구해야 함.
// 첫 번째 묶음부터 순서대로 그 합이 짝수, 홀수, 홀수, 짝수
// 주어진 순서에 상관없이 묶음 만들 수 있음

// 요구사항
// 짝수에서 시작하여 짝홀이 번갈아가게끔. 최대 묶음 수를 구하는 프로그램
// 

// 이해
// 짝수끼리 더하면 짝수, 짝홀끼리 더하면 홀수, 홀수끼리 더하면 짝수
// 홀수가 나오는 경우의 수가 하나기에 이 것만 고려하면 나머지는 모두 짝수
// 각각 하나씩을 나눌 수도 있음. 
// 그 수가 몇인지는 중요하지 않고 짝홀인지만 중요하다.
// 짝수의수와 홀수의수가 같거나 짝수의수가 홀수의수보다 1개 더 많다면 원소의 수가 곧 묶음의 수가 된다.
// But 아니라면 이 비율을 만들게 위해 묶어야 한다. 
// 만약 묶었는데 몇 개가 남을 수 있다. 그렇다면 일부러 많이 묶어야 한다. 
// 일부러 묶을때, 홀수를 만들기 위해서는 홀수에 일부러 짝수(홀홀)를 포함하거나, 짝수(짝짝홀홀)를 만든다.

// 구현
// ex) 홀수개수 7개
// 짝홀을 번갈아가면서 상태를 관리하는 boolean 변수를 만든다. 
// true일 때는 짝, false일 때는 홀임을 나타낸다.
// 계산 후에는 상태를 반대로 바꾼다.
// 짝일때는 짝수개수에서 하나를 빼거나 홀수개수에서 두 개를 빼야한다.
// 홀일때는 짝수개수와 홀수개수에서 하나씩 빼거나, 홀수 개수에서 하나를 뺴야한다.
// 5개남음 4개남음 2개남음 1개남음 -> 짝 차례인데 홀이 하나 남았음. 
// 하나씩 내야하니까 결국 홀에서 또는 짝에서 하나가 남을 것임.
// 홀 차례에서 짝(여러개 남을 수 있음)이 남거나, 짝 차례에서 홀(우선순위로 짝을 만들기 위해 홀 2개면 로직이 실행되므로 꼭 1개)이 남거나!
// 일부러 더할려면, 상태가 안바뀔 수 있는 유일한 수인 짝수가 되어야 한다.
// 짝 차례인데 홀이 남으면 이 홀을 살리기 위해 앞에 짝을 하나 없애야 한다 : 짝홀을 합침. - 짝(홀2) 홀 짝(홀2) 홀 짝(홀1개가 남음)
// 즉 결과적으로 5묶음이 되어야 하는데 앞에 2묶음을 하나로 묶음으로써, 5 - 1(2개를 하나로) 
// - 1(짝홀이 합쳐지면서 짝이하나 없어지므로 마지막 홀을 남은 홀과 더해서 짝으로 만든다. 즉, 2개가 하나로 되니까 -1)
// 짝수가 짝수개 남았으면 짝수만이 되므로 어느 짝수에 붙여도 성립하므로 -1만 해주면 된다.(마지막 원소가 사라지는 것이므로)
// 홀수개 남았으면 그래도 똑같네

// 수도코드
// 홀수개수 :
// 짝수개수
// boolean 홀짝 = False;
// while (홀짝 개수가 둘다 0이 될때까지) {
//     if (홀짝) {}
// }