import Foundation

func solution(_ number:[Int]) -> Int {
    var count = 0
    
    for i in 0..<number.count {
        if (number.count - i < 3) {
            break;
        }
        for j in i+1..<number.count {
            for k in j+1..<number.count {
                if (number[i] + number[j] + number[k] == 0) {
                    count += 1
                }
                
            }
        }
    }
    return count
}