import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int strMaxLen = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            strMaxLen = Math.max(strMaxLen, String.valueOf(arr[i]).length());
        }
            
        int[] radixedSortArr = radix_sort(arr, strMaxLen);

        for (int i = 0; i < radixedSortArr.length; i++) {
            System.out.print(radixedSortArr[i] + " ");
        }
    }

    public static int[] radix_sort(int[] arr, int strMaxLen) {
        
        // 마지막 자리수부터 올라가면서 기수정렬을 한다.
        for (int minus_pos = 0; minus_pos < strMaxLen; minus_pos++) {
            ArrayList<Integer>[] sortedArrByDigit = new ArrayList[10];
            for (int i = 0; i < 10; i++) {
                sortedArrByDigit[i] = new ArrayList<Integer>();
            }
            
            for (int i = 0; i < arr.length; i++) {
                String strArrI = String.valueOf(arr[i]);

                int strArrI_pos = strArrI.length()-1 - minus_pos;
                int arrI_posDigitValue = strArrI_pos >= 0 ? Character.getNumericValue(strArrI.charAt(strArrI_pos)) : 0;
                sortedArrByDigit[arrI_posDigitValue].add(arr[i]);
            }

            int[] tmpArr = new int[arr.length];
            int tmpArrIdx = 0;
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < sortedArrByDigit[i].size(); j++) {
                    tmpArr[tmpArrIdx++] = sortedArrByDigit[i].get(j);
                }
            }

            arr = tmpArr;
        }

        return arr;
    }
}