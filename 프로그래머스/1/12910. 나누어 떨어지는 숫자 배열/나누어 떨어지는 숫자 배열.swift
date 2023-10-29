func solution(_ arr:[Int], _ divisor:Int) -> [Int] {
    var DapArr : [Int] = []
    for i in arr {
        if (i % divisor == 0) {
            DapArr.append(i)
        }
    }
    
    if (DapArr.count == 0) {
        return [-1]
    } else {
        DapArr.sort(by : <) 
        return DapArr
    }
    
}