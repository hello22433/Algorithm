import Foundation

func solution(_ n:Int) -> Int {
    var N = n
    var count = 0
    while (N != 0) {
        if(N%2 == 0) {
            count += N
        }
        N -= 1
    }
    return count
}