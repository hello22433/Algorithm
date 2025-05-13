import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // Please write your code here.
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    int longestLength = Math.max(Math.max(String.valueOf(arr[i]).length(), String.valueOf(arr[j]).length()), String.valueOf(arr[k]).length());
                    
                    String newArrI = extendsLength(arr[i], longestLength);
                    String newArrJ = extendsLength(arr[j], longestLength);
                    String newArrK = extendsLength(arr[k], longestLength);

                    for (int a = 0; a < longestLength; a++) {
                        if (Character.getNumericValue(newArrI.charAt(a)) + Character.getNumericValue(newArrJ.charAt(a)) + Character.getNumericValue(newArrK.charAt(a)) > 9) {
                            break;
                        }
                        if (a == longestLength-1) maxSum = Math.max(maxSum, Integer.parseInt(newArrI) + Integer.parseInt(newArrJ) + Integer.parseInt(newArrK));
                    }
                }
            }
        }
        if (maxSum != Integer.MIN_VALUE) {
            System.out.print(maxSum);
        } else {
            System.out.print(-1);
        }
    }

    public static String extendsLength(int num, int longestLength) {
        StringBuilder sb = new StringBuilder();
        if (String.valueOf(num).length() < longestLength) { // 없어도 되지만 명시적인 이해를 위해 납둠
            for (int i = 0; i < longestLength - String.valueOf(num).length(); i++) {
                sb.append("0");
            }
        }
        sb.append(String.valueOf(num));
        String str = sb.toString();

        return str;
    }
}

// carry 발생 x & 합의최댓값 (서로다른 3개의 수)
// carry : 각 자리수를 더했을때 9를 초과할 경우
// 
// 모든조합을 뽑는다 -> 각자리수를 더한다. how? 가장 긴 문자의 길이를 추출한다. 추출길이에 맞추기 위해 나머지 자리에 0을 채운다. 
// 각 자리수를 더한다. 9를 초과하면 continue;