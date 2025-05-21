import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int B = sc.nextInt();
        int[] p = new int[n];
        int[] s = new int[n];
        int[][] psBox = new int[n][2];
        for(int i = 0; i < n; i++){
            p[i] = sc.nextInt();
            s[i] = sc.nextInt();
            psBox[i][0] = p[i];
            psBox[i][1] = s[i];
        }

        Arrays.sort(psBox, (a,b) -> {
            
            if (a[0]+a[1] == b[0]+b[1]) {
                return a[1]-b[1];
            }

            return a[0]+a[1] - (b[0]+b[1]);
        });

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int presentPrice = psBox[i][0];
            int deliveryFee = psBox[i][1];
            int TotalPrice = presentPrice + deliveryFee;

            if (B - TotalPrice >= 0) {
                B -= TotalPrice;
                cnt++;
            } else {
                presentPrice /= 2;

                if (B - (presentPrice + deliveryFee) >= 0) {
                    cnt++;
                }
                break;
            }
        }

        System.out.print(cnt);
    }   
}

// 합쳐진 가격이 싼 순으로 정렬해야 한다. 
// 할인 받는 것은 선물 하나 뿐.
// 합쳐진 가격이 싼 순으로 오름차순 정렬을 하되, 
// 같은 가격이라면 배송비가 더 비싼게 뒤로 가야 유리하다. (할인 가격이 올라가므로)
// 
