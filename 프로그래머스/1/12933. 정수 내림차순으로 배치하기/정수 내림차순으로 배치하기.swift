import Foundation

func solution(_ n:Int64) -> Int64 {
    let N = String(n)
    var Narr: [String] = []
    
    for i in N {
        let i = String(i)
        Narr.insert(i, at:0)
    }
    
    var result0 = Int64(Narr.sorted(by: >).joined(separator:""))
    
    let result : Int64? = result0
    
    if let unrappedResult = result {
        return unrappedResult
    } else {
        return 4
    }
}