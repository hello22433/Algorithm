func solution(_ s:String, _ n:Int) -> String {
    var sArr : [String] = []
    
    for i in s {
        let i = String(i)
        
        if (i == " ") {
            sArr.append(" ")
            continue
        }
        
        var plusOneUnicode = Int(UnicodeScalar(i)!.value) + n
        if (UnicodeScalar(i)!.value > 91 && plusOneUnicode > 122) {
            plusOneUnicode = plusOneUnicode - 122 + 96
        } else if (UnicodeScalar(i)!.value < 91 && plusOneUnicode > 90) {
            plusOneUnicode = plusOneUnicode - 90 + 64
        }
        let unicodeToString = String(UnicodeScalar(plusOneUnicode)!)
        sArr.append(unicodeToString)
    }
    
    return sArr.joined(separator:"")
}


//1. 반복문으로 순회탐색
//2. 순회탐색하면서 n만큼 민다. ?미는 기준을 정하기 위해 아스키코드 사용. ?아스키코드로 각각에 n만큼 더해서 다시 변환하여 새로운 배열에 넣는다.