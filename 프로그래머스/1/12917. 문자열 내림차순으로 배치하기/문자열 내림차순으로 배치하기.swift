import Foundation

func solution(_ s:String) -> String {
    var S = s
    var arrS : [String] = []
    
    for i in S {
        var i = String(i)
        arrS.append(i)
    }
    return String(arrS.sorted(by: >).joined(separator:""))
    
    /*
    var S = s.components(separatedBy:"")
    print(S.sorted(by: <))
    return String(S.sorted(by: <).joined(separator:""))
    */
}