import java.util.Scanner;

public class Main {
    public static int n;
    public static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n + 1]; // 인덱스 1부터 사용
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        heap_sort();

        for (int i = 1; i <= n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // heapify 함수는 현재 힙 크기(size)를 인자로 받음
    public static void heapify(int i, int size) {
        int largest = i;
        int l = i * 2;
        int r = i * 2 + 1;

        if (l <= size && arr[l] > arr[largest]) {
            largest = l;
        }

        if (r <= size && arr[r] > arr[largest]) {
            largest = r;
        }

        if (largest != i) {
            int tmp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = tmp;
            heapify(largest, size); // 재귀적으로 하위 힙 정렬
        }
    }

    public static void heap_sort() {
        // 1. 최대 힙 만들기
        for (int i = n / 2; i >= 1; i--) {
            heapify(i, n);
        }

        // 2. 루트와 마지막 원소 교환하고, 힙 크기를 줄이며 정렬 반복
        for (int i = n; i > 1; i--) {
            int tmp = arr[1];
            arr[1] = arr[i];
            arr[i] = tmp;

            // 힙 크기를 i - 1로 줄이고 다시 정렬
            heapify(1, i - 1);
        }
    }
}
