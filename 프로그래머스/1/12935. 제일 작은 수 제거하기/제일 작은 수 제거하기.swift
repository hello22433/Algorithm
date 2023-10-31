func solution(_ arr:[Int]) -> [Int] {
    
    var arrSorted = arr.sorted(by: >)
    
    var arrLast = arrSorted.last
    
    var newArr : [Int] = []
    
    for i in arr {
        if (i != arrLast) { 
            newArr.append(i)
        }
    }
    
    if (newArr.count == 0) {
        return [-1]
    }
    
    return newArr
}
