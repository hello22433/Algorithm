func solution(_ x:Int) -> Bool {
    let xString = String(x)
    var xHap = 0
    
    for i in xString {
        var i = String(i)
        xHap += Int(i)!
    }
    
    if (x % xHap == 0) {
        return true
    } else {
        return false
    }
}
