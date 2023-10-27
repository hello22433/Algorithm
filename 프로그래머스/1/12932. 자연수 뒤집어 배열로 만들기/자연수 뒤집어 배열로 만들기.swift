func solution(_ n:Int64) -> [Int] {
    var nStr = String(n)
    var nArr : [Int] = []
    var count = 0
    
    for i in nStr {
        let i = Int(String(i))
        nArr.insert(i!, at: 0)
        count += 1
    }
    return nArr
}