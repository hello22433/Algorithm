func solution(_ x:Int, _ n:Int) -> [Int64] {
    let Wonsyx = x
    var X = x
    var Xarr:[Int64] = []
    while Xarr.count < n {
        Xarr.append(Int64(X))
        X += Wonsyx
    }
    return Xarr
}