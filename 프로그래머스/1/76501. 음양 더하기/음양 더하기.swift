import Foundation

func solution(_ absolutes:[Int], _ signs:[Bool]) -> Int {
    var hap = 0
    
    for i in 0 ..< signs.count {
        if (signs[i] == true) {
            hap += absolutes[i]
        } else {
            hap -= absolutes[i]
        }
    }
    return hap
}