import Foundation

func solution(_ array:[Int], _ commands:[[Int]]) -> [Int] {
    
    var result : [Int] = []
    
    for i in commands {
        let bucket = array[i[0] - 1..<i[1]].sorted(by : <)
        result.append(bucket[i[2] - 1])
    }
    
    return result
    
}

// 1. commands 순회탐색
// 2. 탐색한 것에서 숫자 추출.
// 3. 추출한 것으로 array에서 부분 문자열 추출