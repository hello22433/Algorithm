import Foundation

func solution(_ numbers:[Int]) -> [Int] {
    
    var bucket : [Int] = []
    
    for i in 0...numbers.count - 2 {
        for j in i+1...numbers.count - 1 {
            bucket.append(numbers[i] + numbers[j])
        }
    }
    
    let result = Array(Set(bucket)).sorted(by: <) 
    
    return result
}