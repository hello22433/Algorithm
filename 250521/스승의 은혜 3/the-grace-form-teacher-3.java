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
            
            // 같을떄? 크거나 같을떄? 
            // 토탈 비용으로 오름차순할 건데,,, 동시에 상품 가격으로 오름차순하는게 맞다.
            // 토탈비용이 더 높더라도 상품 가격이 더 높아서 할인했을 때 구매가 가능할 수 있다. 
            // 그럼 구매가 불가할 때 상품 가격이 더 높은 것을 고려해야겠지.
            // 그래서 같은 가격이라면 배송비로 오름차순(상품가격 내림차순) 한거니까..
            // 근데 같은 가격이 아니라 가격이 더 비싼 경우에도 고려해야 한다.
            // 남은 것들 중에 모두 고려해보면 되지 않을까?
            if (a[0]+a[1] == b[0]+b[1]) {
                return a[1]-b[1];
            }

            return a[0]+a[1] - (b[0]+b[1]);
        });

        int cnt = 0;
        outer : for (int i = 0; i < n; i++) {
            int presentPrice = psBox[i][0];
            int deliveryFee = psBox[i][1];
            int TotalPrice = presentPrice + deliveryFee;

            if (B - TotalPrice >= 0) {
                B -= TotalPrice;
                cnt++;
            } else {
                for (int j = i; j < n; j++) {
                    presentPrice = psBox[j][0];
                    deliveryFee = psBox[j][1];
                    TotalPrice = presentPrice + deliveryFee;

                    presentPrice /= 2;
                    if (B - (presentPrice + deliveryFee) >= 0) {
                        cnt++;
                        break outer;
                    }
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
