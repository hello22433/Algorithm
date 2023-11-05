import Foundation

func solution(_ s:String) -> [Int] {
    var sArrReverse : [String] = []
    var sArr : [String] = []
    var result : [Int] = []
    
    for i in s {
        let i = String(i)
        sArrReverse.insert(i, at:0)
        sArr.append(i)
    }
    
    for i in 0..<sArrReverse.count {
        var count = 0
        if (i == sArrReverse.count - 1) {
            result.insert(-1, at:0)
            break;
        }
        for j in i+1..<sArrReverse.count {
            count += 1
            if (sArrReverse[i] == sArrReverse[j]) {
                result.insert(count, at:0)
                break;
            } else if (j == sArrReverse.count - 1) {
                result.insert(-1, at:0)
            }
        }
    }
    
    return result
}


//1. 문자열을 순회탐색하는데, 동시에 문자열을 거꾸로 순회탐색하면서 똑같은거 있는지 탐색한다.
//2. 거꾸로 셀 떄마다 count를 세고 똑같은 게 있으면 result에 count를 넣는다.