func solution(_ n:Int) -> String {
    var count = 1
    var result : [String] = []
    
    while (count <= n) {
        if (count % 2 == 1) {
            result.append("수")
        } else {
            result.append("박")
        }
        count += 1
    } 
    return result.joined(separator:"")
}