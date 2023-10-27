import Foundation

func solution(_ n:Int) -> Int
{
    print(n)
    var answer = 0
    var N = String(n)
    
    for row in N {
        var Row = Int(String(row))
        answer += Row!
    }
    
    return answer
}