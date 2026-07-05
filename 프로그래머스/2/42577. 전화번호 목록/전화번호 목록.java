import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        
        Arrays.sort(phone_book, (a,b) -> {
            return Integer.compare(a.length(), b.length());
        });
            
        Set<String> phone_set = new HashSet<>();
        for (String num : phone_book) {
            for (int i = 1; i <= num.length(); i++) {
                String cutted_num = num.substring(0,i);
                
                if (phone_set.contains(cutted_num)) {
                    return false;
                } 
                
                if (i == num.length()) {
                    phone_set.add(cutted_num);
                }
            }
        }
        
        return true;
    }
}

// if(phone_num.contains(phone_num)

// phone_book 을 하나씩 돌면서, 자르면서 넣는다.
// 넣기 전에 해당 값이 hashset에 들어있는지 체크한다.