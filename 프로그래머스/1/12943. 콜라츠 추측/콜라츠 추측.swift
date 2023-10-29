func solution(_ num:Int) -> Int {
    var Num = num
    
    if (Num == 1) {
        return 0
    }    

    for i in 1...500 {
        
        if (Num % 2 == 0) {
            Num = Num / 2
        } else {
            Num = Num * 3 + 1
        }
        if (Num == 1) {
            return i
        }
    }
    
    return -1
}