import Foundation

func solution(_ price:Int, _ money:Int, _ count:Int) -> Int64{
    var answer = 0
    
    for i in 1...count {
        answer += price * i 
    }
    
    let result = answer - money
    
    if (result > 0) {
        return Int64(result)
    } else {
        return 0
    }
}