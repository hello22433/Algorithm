import Foundation

func solution(_ k:Int, _ m:Int, _ score:[Int]) -> Int {
    var scoreCopy = score.sorted(by: >)
    var count = 0
    var result = 0
    
    while (scoreCopy.count - 1 >= (m - 1) + m * count) {
        let lastSoo = scoreCopy[(m - 1) + m * count]
        count += 1
        
        result += lastSoo * m
    }
    return result
}