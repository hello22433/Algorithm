import Foundation

func solution(_ cards1:[String], _ cards2:[String], _ goal:[String]) -> String {
    
    var cards1 = cards1
    var cards2 = cards2
    var goalcopy = goal
    
    for i in goal {
        if (cards1.count > 0 && cards1[0] == i) {
            cards1.remove(at:0)
            goalcopy.remove(at:0)
            if (goalcopy.count == 0) {
            return "Yes"
        }
            continue
        }
        if (cards2.count > 0 && cards2[0] == i) {
            cards2.remove(at:0)
            goalcopy.remove(at:0)
            if (goalcopy.count == 0) {
            return "Yes"
        }
            continue
        }
        
            return "No"
    }
    return "No"
}
// 1. goal을 순회탐색 한다.
// 2. 중복순회탐색으로 cards1과 cards2의 처음을 돌린다.
// 3. 처음에 없다면 reutnr "No". 처음에 있다면 해당 배열에서 삭제하고 Break; 
// 4. 반복하여 cards1과 cards2 count가 둘다 0이면 "Yes"