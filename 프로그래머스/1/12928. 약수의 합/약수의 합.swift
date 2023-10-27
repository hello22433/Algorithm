func solution(_ n:Int) -> Int {
    var i = 1
    var Aksoo = 0
    
    while (i < n+1) {
        if (n % i == 0) {
            Aksoo += i
        }
        i += 1
    }
    return Aksoo
}