import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }
        
        // 오른쪽으로
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m-2; j++) {
                StringBuilder sb = new StringBuilder();
                sb.append(arr[i].charAt(j));
                sb.append(arr[i].charAt(j+1));
                sb.append(arr[i].charAt(j+2));
                String str = sb.toString();
                if (str.equals("LEE") || str.equals("EEL")) {
                    count++;
                }
            }
        }

        // 아래쪽으로
        for (int i = 0; i < n-2; i++) {
            for (int j = 0; j < m; j++) {
                StringBuilder sb = new StringBuilder();
                sb.append(arr[i].charAt(j));
                sb.append(arr[i+1].charAt(j));
                sb.append(arr[i+2].charAt(j));
                String str = sb.toString();
                if (str.equals("LEE") || str.equals("EEL")) {
                    count++;
                }
            }
        }

        // 오른쪽아래로
        for (int i = 0; i < n-2; i++) {
            for (int j = 0; j < m-2; j++) {
                StringBuilder sb = new StringBuilder();
                sb.append(arr[i].charAt(j));
                sb.append(arr[i+1].charAt(j+1));
                sb.append(arr[i+2].charAt(j+2));
                String str = sb.toString();
                if (str.equals("LEE") || str.equals("EEL")) {
                    count++;
                }
            }
        }

        // 오른쪽위로
        for (int i = 2; i < n; i++) {
            for (int j = 0; j < m-2; j++) {
                StringBuilder sb = new StringBuilder();
                sb.append(arr[i].charAt(j));
                sb.append(arr[i-1].charAt(j+1));
                sb.append(arr[i-2].charAt(j+2));
                String str = sb.toString();
                if (str.equals("LEE") || str.equals("EEL")) {
                    count++;
                }
            }
        }

        System.out.print(count);
    }
}

// 오른쪽으로3 아래로3 오른쪽아래로3 오른쪽위로3
// 