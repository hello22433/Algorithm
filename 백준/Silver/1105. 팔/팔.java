import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 처음부터 문자열로 입력받기 (20억이라는 큰 수 대응)
        String LS = sc.next();
        String RS = sc.next();

        int result = 0;

        // 1. 자릿수가 다르면 무조건 0 (예: 88과 100 사이엔 90이 있음)
        if (LS.length() != RS.length()) {
            System.out.print(0);
            return;
        }

        // 2. 자릿수가 같을 때만 앞에서부터 비교
        for (int i = 0; i < LS.length(); i++) {
            // 같은 자리에 둘 다 8이 있으면 무조건 포함될 수밖에 없음
            if (LS.charAt(i) == RS.charAt(i)) {
                if (LS.charAt(i) == '8') {
                    result++;
                }
            } else {
                // 숫자가 달라지는 순간부터는 8이 없는 숫자를 만들 수 있음
                break;
            }
        }

        System.out.print(result);
    }
}