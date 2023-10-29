func solution(_ a:Int, _ b:Int) -> Int64 {
    var hap = 0
    
    if (a < b) {
        for i in a...b {
            hap += i
        }
    } else {
        for i in b...a {
            hap += i
        }
    }
    
    
    return Int64(hap)
}