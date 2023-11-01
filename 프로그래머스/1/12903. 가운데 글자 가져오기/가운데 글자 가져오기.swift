func solution(_ s:String) -> String {
    var S : [String] = []
    
    for i in s {
        let i = String(i)
        S.append(i)
    }
    
    if (S.count % 2 == 1) {
        return (S[(S.count/2)])
    } else {
        return (S[(S.count/2 - 1)...(S.count/2)].joined(separator:"")) 
    }
    
}