func solution(_ arr:[Int]) -> Double {
    var hap = 0
    for row in arr {
        hap += row
    }
    return Double(Double(hap)/Double(arr.count))
}