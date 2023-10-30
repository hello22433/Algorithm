import Foundation

func solution(_ numbers:[Int]) -> Int {
    var result = 45
    
    for i in numbers {
        result -= i 
    }
    
    return result
}