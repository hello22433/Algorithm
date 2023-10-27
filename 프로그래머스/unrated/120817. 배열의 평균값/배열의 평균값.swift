import Foundation

func solution(_ numbers:[Int]) -> Double {
    var hap = 0
    for row in numbers {
        hap += row
    }
    return Double(Double(hap)/Double(numbers.count))
}