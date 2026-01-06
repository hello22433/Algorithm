import java.util.*;

class Flower {
    int start;
    int end;
    
    Flower(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        Flower[] flowers = new Flower[n];
        
        for (int i = 0; i < n; i++) {
            int sm = sc.nextInt();
            int sd = sc.nextInt();
            int em = sc.nextInt();
            int ed = sc.nextInt();
            
            int startMD = sm * 100 + sd;
            int endMD = em * 100 + ed;
            
            flowers[i] = new Flower(startMD, endMD);
            
        }
        
        Arrays.sort(flowers, (a,b) -> {
           // if (a.start == b.start) return b.end - a.end;
           return a.start - b.start;
        });
        
        final int START = 301;
        final int END = 1130;
        
        int idx = 0; // 꽃 배열 포인터
        int count = 0; // 선택한 꽃 수
        int cur = START; // 현재 덮어야하는 날짜
        
        while (cur <= END) {
            
            int maxEnd = cur;
            
            while (idx < n && flowers[idx].start <= cur) {
                maxEnd = Math.max(maxEnd, flowers[idx].end);
                idx++;
            }
            
            if (maxEnd == cur) {
                System.out.print(0);
                return;
            }
            
            cur = maxEnd;
            count++;
        }
        
        System.out.print(count);
    }
}