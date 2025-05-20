import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ability1 = sc.nextInt();
        int ability2 = sc.nextInt();
        int ability3 = sc.nextInt();
        int ability4 = sc.nextInt();
        int ability5 = sc.nextInt();
        int ability6 = sc.nextInt();
        int sum = ability1 + ability2 + ability3 + ability4 + ability5 + ability6;

        int[] abilities = {ability1, ability2, ability3, ability4, ability5, ability6};

        int minDiffer = Integer.MAX_VALUE;
        // 1팀 정하기
        for (int i = 0; i < 6-1; i++) {
            int sum1 = 0;
            int sum2 = 0;
            int sum3 = 0;

            for (int j = i+1; j < 6; j++) {
                sum1 = abilities[i] + abilities[j];
                //2팀 정하기(동시에 3팀을 정하게 됨)
                for (int k = 0; k < 6-1; k++) {
                    for (int l = k+1; l < 6; l++) {
                        if (k==i || k==j || l==i || l==j) continue;
                        sum2 = abilities[k] + abilities[l];
                        sum3 = sum - (sum1 + sum2);

                        int maxSum = Math.max(sum1, Math.max(sum2,sum3));
                        int minSum = Math.min(sum1, Math.min(sum2,sum3));
                        int difference = maxSum - minSum;
                        minDiffer = Math.min(minDiffer, difference);
                    }
                }
            }
        }
        System.out.print(minDiffer);
    }
}

// 6명을 2명씩 3팀으로 배정
// 가장 큰팀 - 가장 작은 팀
// 2명 고르고, 2명 고르고 각각의 합을 더한다.