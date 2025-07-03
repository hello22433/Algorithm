import java.util.Scanner;

public class Main {
    static int[] arr;
    static int[] merged_arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        merged_arr = new int[arr.length];


        merge_sort(0, arr.length-1);

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void merge_sort(int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            merge_sort(low, mid);
            merge_sort(mid+1, high);
            merge(low, mid, high);
        }
    }

    public static void merge(int low, int mid, int high) {
        
        int i = low;
        int j = mid + 1;
        int k = low;

        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) {
                merged_arr[k++] = arr[i++];
            } else {
                merged_arr[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            merged_arr[k++] = arr[i++];
        }

        while (j <= high) {
            merged_arr[k++] = arr[j++];
        }

        for (int l = low; l <= high; l++) {
            arr[l] = merged_arr[l];
        }
    } 
}