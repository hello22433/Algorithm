import Foundation

func solution(_ k:Int, _ score:[Int]) -> [Int] {
    var jeondang : [Int] = []
    var result : [Int] = []
    
    for i in score {
        jeondang.append(i)
        jeondang.sort(by:>)
        if (jeondang.count >= k) {
            result.append(Int(jeondang[0...k - 1].last!))
            } else {
            result.append(Int(jeondang.last!))
        }
    }
    
    return result
}

// 1. 명예의 전당에 하나씩 넣으면서 계속 정렳한다. 그리고 k로 끊어서 마지막 수를 result배열에 넣는다.
// 2. 