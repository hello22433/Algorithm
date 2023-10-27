import Foundation

func solution(_ n:Int) -> Int {
    var mo = 2
    while mo < n {
        if (n % mo == 1) {
            return mo
        }
        mo += 1
    }
    return mo
}