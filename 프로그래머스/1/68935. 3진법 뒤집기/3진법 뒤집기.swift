import Foundation

func solution(_ n:Int) -> Int {
    
    var a = String(n, radix: 3)
    a = String(a.reversed())
    var b = Int(a, radix: 3)
    
    return b!
}