import Foundation

func solution(_ n:Int64) -> Int64 {
    var N = Double(n)
    if (sqrt(N) - floor(sqrt(N)) != 0) {
        return -1
    } else {
        return Int64(pow(sqrt(N)+1,2))
    }
}